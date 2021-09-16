package com.sandino.pandemiccombataidsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.sandino.pandemiccombataidsystem.dtos.HospitalExchangeDTO;
import com.sandino.pandemiccombataidsystem.entities.Exchange;
import com.sandino.pandemiccombataidsystem.entities.ExchangeResource;
import com.sandino.pandemiccombataidsystem.entities.Hospital;
import com.sandino.pandemiccombataidsystem.entities.Resource;
import com.sandino.pandemiccombataidsystem.exceptions.ApiRequestException;
import com.sandino.pandemiccombataidsystem.repositories.ExchangeRepository;
import com.sandino.pandemiccombataidsystem.repositories.ExchangeResourceRepository;
import com.sandino.pandemiccombataidsystem.repositories.HospitalRepository;
import com.sandino.pandemiccombataidsystem.repositories.ResourceRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExchangeService {

    private HospitalRepository hospitalRepository;
    private ResourceRepository resourceRepository;
    private ExchangeRepository exchangeRepository;
    private ExchangeResourceRepository exchangeResourceRepository;

    public ExchangeService(HospitalRepository hospitalRepository, ResourceRepository resourceRepository,
            ExchangeRepository exchangeRepository, ExchangeResourceRepository exchangeResourceRepository) {
        this.hospitalRepository = hospitalRepository;
        this.resourceRepository = resourceRepository;
        this.exchangeRepository = exchangeRepository;
        this.exchangeResourceRepository = exchangeResourceRepository;
    }

    @Transactional
    public List<Exchange> exchangeResources(HospitalExchangeDTO hospitalExchangeDTO) {

        // Retrieve hospitals
        Hospital firstHospital = retrieveHospitals(hospitalExchangeDTO.getFirstHospital().getHospitalId());
        Hospital secondHospital = retrieveHospitals(hospitalExchangeDTO.getSecondHospital().getHospitalId());

        // Retrieve resources of a hospital
        List<Resource> firstHospitalResources = retrieveResources(firstHospital,
                hospitalExchangeDTO.getFirstHospital().getResources());
        List<Resource> secondHospitalResources = retrieveResources(secondHospital,
                hospitalExchangeDTO.getSecondHospital().getResources());

        // Calculate the value of the resources
        int firstHospitalResourcesValue = calculateValue(firstHospitalResources);
        int secondHospitalResourcesValue = calculateValue(secondHospitalResources);

        // Validate the transaction
        if (firstHospital.getOccupationPercentage() >= 90
                && firstHospitalResourcesValue > secondHospitalResourcesValue) {
            throw new ApiRequestException("The first hospital cannot offer this amount of resources");
        }

        if (secondHospital.getOccupationPercentage() >= 90
                && secondHospitalResourcesValue > firstHospitalResourcesValue) {
            throw new ApiRequestException("The second hospital cannot offer this amount of resources");
        }

        if (firstHospital.getOccupationPercentage() < 90 && secondHospital.getOccupationPercentage() < 90
                && firstHospitalResourcesValue != secondHospitalResourcesValue) {
            throw new ApiRequestException("The resources values must be equivalent");
        }

        // Create exchange objects
        Exchange firstHospitalExchange = new Exchange(firstHospital, secondHospital);
        Exchange secondHospitalExchange = new Exchange(secondHospital, firstHospital);

        // Create exchange resources
        List<ExchangeResource> firstHospitalExchangeResource = firstHospitalResources.stream()
                .map(resource -> new ExchangeResource(firstHospitalExchange, resource)).collect(Collectors.toList());

        List<ExchangeResource> secondHospitalExchangeResource = secondHospitalResources.stream()
                .map(resource -> new ExchangeResource(secondHospitalExchange, resource)).collect(Collectors.toList());

        // Link the resource and the exchange resources in order to return the complete object
        firstHospitalExchange.setExchangeResources(firstHospitalExchangeResource);
        secondHospitalExchange.setExchangeResources(secondHospitalExchangeResource);

        // Save the exchange
        exchangeRepository.save(firstHospitalExchange);
        exchangeRepository.save(secondHospitalExchange);

        // Save the exchange resources
        exchangeResourceRepository.saveAll(firstHospitalExchangeResource);
        exchangeResourceRepository.saveAll(secondHospitalExchangeResource);

        // Update the resources with the new hospital
        firstHospitalResources.stream().forEach(resource -> resource.setHospital(secondHospital));
        secondHospitalResources.stream().forEach(resource -> resource.setHospital(firstHospital));

        // return the two exchange objects created
        return List.of(firstHospitalExchange, secondHospitalExchange);
    }

    private Integer calculateValue(List<Resource> firstHospitalResources) {
        return firstHospitalResources.stream().distinct().map(resource -> resource.getResourceType().getValue())
                .reduce(0, (acc, resourceValue) -> acc + resourceValue);
    }

    private List<Resource> retrieveResources(Hospital firstHospital, List<String> firstHospitalResourcesIds) {
        return firstHospitalResourcesIds.stream()
                .map(resourceId -> resourceRepository.findByIdAndHospital(resourceId, firstHospital)
                        .orElseThrow(() -> new ApiRequestException("Could not find a resource with ID " + resourceId)))
                .collect(Collectors.toList());
    }

    private Hospital retrieveHospitals(String firstHospitalId) {
        return hospitalRepository.findById(firstHospitalId)
                .orElseThrow(() -> new ApiRequestException("Could not find a hospital with ID " + firstHospitalId));
    }
}
