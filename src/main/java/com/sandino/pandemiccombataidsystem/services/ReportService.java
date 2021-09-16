package com.sandino.pandemiccombataidsystem.services;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sandino.pandemiccombataidsystem.dtos.AverageResourceTypeDTO;
import com.sandino.pandemiccombataidsystem.dtos.ReportDTO;
import com.sandino.pandemiccombataidsystem.entities.Exchange;
import com.sandino.pandemiccombataidsystem.entities.Hospital;
import com.sandino.pandemiccombataidsystem.entities.Resource;
import com.sandino.pandemiccombataidsystem.entities.ResourceType;
import com.sandino.pandemiccombataidsystem.exceptions.ApiRequestException;
import com.sandino.pandemiccombataidsystem.repositories.ExchangeRepository;
import com.sandino.pandemiccombataidsystem.repositories.HospitalRepository;
import com.sandino.pandemiccombataidsystem.repositories.ResourceRepository;

import org.springframework.stereotype.Service;

@Service
public class ReportService {

    HospitalRepository hospitalRepository;
    ResourceRepository resourceRepository;
    ExchangeRepository exchangeRepository;

    public ReportService(HospitalRepository hospitalRepository, ResourceRepository resourceRepository,
            ExchangeRepository exchangeRepository) {
        this.hospitalRepository = hospitalRepository;
        this.resourceRepository = resourceRepository;
        this.exchangeRepository = exchangeRepository;
    }

    public ReportDTO generate() {
        List<Hospital> hospitals = hospitalRepository.findAll();

        int numberOfHospitals = hospitals.size();

        if (numberOfHospitals == 0) {
            throw new ApiRequestException("There's no hospitals on the database");
        }

        long hospitalsUndercrowdedCount = hospitals.stream().filter(hospital -> hospital.getOccupationPercentage() < 90)
                .count();

        long hospitalsOvercrowdedCount = numberOfHospitals - hospitalsUndercrowdedCount;

        long hospitalsUndercrowdedPercentage = hospitalsUndercrowdedCount * 100 / numberOfHospitals;
        long hospitalsOvercrowdedPercentage = hospitalsOvercrowdedCount * 100 / numberOfHospitals;

        Hospital overcrowdedLonger = hospitals.stream().filter(hospital -> hospital.getOccupationPercentage() > 90)
                .min(Comparator.comparing(Hospital::getOccupationUpdatedAt))
                .orElse(null);

        Hospital undercrowdedLonger = hospitals.stream().filter(hospital -> hospital.getOccupationPercentage() <= 90)
                .min(Comparator.comparing(Hospital::getOccupationUpdatedAt))
                .orElse(null);

        List<Resource> resources = resourceRepository.findAll();

        Map<ResourceType, Long> frequencyMap = resources.stream()
                .collect(Collectors.groupingBy(Resource::getResourceType, Collectors.counting()));

        List<Exchange> exchanges = exchangeRepository.findAll();

        List<AverageResourceTypeDTO> averageResourceTypes = frequencyMap.entrySet().stream()
                .map(entry -> new AverageResourceTypeDTO(entry.getKey(), entry.getValue().doubleValue() / numberOfHospitals))
                .collect(Collectors.toList());

        return new ReportDTO(hospitalsOvercrowdedPercentage, hospitalsUndercrowdedPercentage, overcrowdedLonger,
                undercrowdedLonger, averageResourceTypes, exchanges);
    }
}
