package com.sandino.pandemiccombataidsystem.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.sandino.pandemiccombataidsystem.dtos.HospitalDTO;
import com.sandino.pandemiccombataidsystem.dtos.OccupationPercentageDTO;
import com.sandino.pandemiccombataidsystem.entities.Hospital;
import com.sandino.pandemiccombataidsystem.entities.Resource;
import com.sandino.pandemiccombataidsystem.exceptions.ApiRequestException;
import com.sandino.pandemiccombataidsystem.repositories.HospitalRepository;
import com.sandino.pandemiccombataidsystem.repositories.ResourceRepository;
import com.sandino.pandemiccombataidsystem.repositories.ResourceTypeRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HospitalService {

    private HospitalRepository hospitalRepository;
    private ResourceRepository resourceRepository;
    private ResourceTypeRepository resourceTypeRepository;

    public HospitalService(HospitalRepository hospitalRepository, ResourceRepository resourceRepository,
            ResourceTypeRepository resourceTypeRepository) {
        this.hospitalRepository = hospitalRepository;
        this.resourceRepository = resourceRepository;
        this.resourceTypeRepository = resourceTypeRepository;
    }

    public List<Hospital> list() {
        return hospitalRepository.findAll();
    }

    @Transactional
    public Hospital create(HospitalDTO hospitalDTO) {

        // Create hospital object
        Hospital hospital = new Hospital(hospitalDTO.getName(), hospitalDTO.getAddress(), hospitalDTO.getCnpj(),
                hospitalDTO.getLatitude(), hospitalDTO.getLongitude(), hospitalDTO.getOccupationPercentage(), LocalDateTime.now());

        // Create the resources to be saved
        List<Resource> resources = hospitalDTO.getResources().stream()
                .map(resource -> new Resource(resource.getName(), hospital,
                        resourceTypeRepository.findById(resource.getType())
                                .orElseThrow(() -> new ApiRequestException(
                                        "Could not find a resource type with ID: " + resource.getType()))))
                .collect(Collectors.toList());

        hospital.setResources(resources);

        hospitalRepository.save(hospital);

        resourceRepository.saveAll(resources);

        return hospital;
    }

    public Hospital retrieve(String hospitalId) {
        return hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new ApiRequestException("Could not find a hospital with ID: " + hospitalId));
    }

    @Transactional
    public Hospital updateOccupationPercentage(String hospitalId, OccupationPercentageDTO occupationPercentageDTO) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new ApiRequestException("Could not find a hospital with ID: " + hospitalId));

        hospital.setOccupationPercentage(occupationPercentageDTO.getOccupationPercentage());
        hospital.setOccupationUpdatedAt(LocalDateTime.now());

        return hospital;
    }
}
