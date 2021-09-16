package com.sandino.pandemiccombataidsystem.repositories;

import java.util.List;
import java.util.Optional;

import com.sandino.pandemiccombataidsystem.entities.Hospital;
import com.sandino.pandemiccombataidsystem.entities.Resource;

import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, String> {
    List<Resource> findAll();
    List<Resource> findAllById(Iterable<String> ids);
    Optional<Resource> findByIdAndHospital(String id, Hospital hospital);
}
