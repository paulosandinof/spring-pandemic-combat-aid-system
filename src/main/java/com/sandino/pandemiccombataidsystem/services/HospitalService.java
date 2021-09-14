package com.sandino.pandemiccombataidsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.sandino.pandemiccombataidsystem.dtos.HospitalDTO;
import com.sandino.pandemiccombataidsystem.entities.Hospital;
import com.sandino.pandemiccombataidsystem.entities.Resource;
import com.sandino.pandemiccombataidsystem.repositories.HospitalRepository;
import com.sandino.pandemiccombataidsystem.repositories.ResourceRepository;
import com.sandino.pandemiccombataidsystem.repositories.ResourceTypeRepository;

import org.springframework.stereotype.Service;

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

    public Hospital create(HospitalDTO hospitalDTO) {

        // Cria os objetos Resource para serem salvos
        List<Resource> resources = hospitalDTO.getResources().stream().map(
                resource -> new Resource(resource.getName(), resourceTypeRepository.findById(resource.getType()).get()))
                .collect(Collectors.toList());

        // Salva os Resources
        resourceRepository.saveAll(resources);

        // Cria o objeto Hospital
        Hospital hospital = new Hospital(hospitalDTO.getName(), hospitalDTO.getAddress(), hospitalDTO.getCnpj(),
                hospitalDTO.getLatitude(), hospitalDTO.getLongitude(), hospitalDTO.getOccupationPercentage(),
                resources);

        // Salva o hospital
        return hospitalRepository.save(hospital);
    }
}
