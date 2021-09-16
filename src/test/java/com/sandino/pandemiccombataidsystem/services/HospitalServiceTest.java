package com.sandino.pandemiccombataidsystem.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.sandino.pandemiccombataidsystem.dtos.HospitalDTO;
import com.sandino.pandemiccombataidsystem.dtos.ResourceDTO;
import com.sandino.pandemiccombataidsystem.entities.Hospital;
import com.sandino.pandemiccombataidsystem.entities.ResourceType;
import com.sandino.pandemiccombataidsystem.repositories.HospitalRepository;
import com.sandino.pandemiccombataidsystem.repositories.ResourceRepository;
import com.sandino.pandemiccombataidsystem.repositories.ResourceTypeRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HospitalServiceTest {

    @Mock
    private HospitalRepository hospitalRepository;

    @Mock
    private ResourceRepository resourceRepository;

    @Mock
    private ResourceTypeRepository resourceTypeRepository;

    @Test
    void itShouldCreateANewHospital() {

        // Given
        List<ResourceDTO> resources = List.of(
                new ResourceDTO("Maria de Fátima", "0ca7f082-1eee-48d1-aa11-8594156468e1"),
                new ResourceDTO("Antônio Gomes", "30ee7abf-0106-4f32-8cc2-550b94bc99f9"));

        HospitalDTO hospitalDTO = new HospitalDTO("Hospital Walfredo Gurgel", "Rua Mossoró, 8945", "9876543210",
                80.0000, 32.0000, 93.5, resources);

        // When
        when(resourceTypeRepository.findById("0ca7f082-1eee-48d1-aa11-8594156468e1"))
                .thenReturn(Optional.of(new ResourceType("0ca7f082-1eee-48d1-aa11-8594156468e1", "Médico", 3,
                        LocalDateTime.now(), LocalDateTime.now())));
        when(resourceTypeRepository.findById("30ee7abf-0106-4f32-8cc2-550b94bc99f9"))
                .thenReturn(Optional.of(new ResourceType("30ee7abf-0106-4f32-8cc2-550b94bc99f9", "Enfermeiro", 3,
                        LocalDateTime.now(), LocalDateTime.now())));

        HospitalService hospitalService = new HospitalService(hospitalRepository, resourceRepository,
                resourceTypeRepository);

        Hospital hospital = hospitalService.create(hospitalDTO);

        // Then
        assertThat(hospital.getName()).isEqualTo("Hospital Walfredo Gurgel");
        assertThat(hospital.getResources().size()).isEqualTo(2);
    }
}
