package com.sandino.pandemiccombataidsystem.repositories;

import java.util.List;

import com.sandino.pandemiccombataidsystem.entities.ResourceType;

import org.springframework.data.repository.CrudRepository;

public interface ResourceTypeRepository extends CrudRepository<ResourceType, String> {
    List<ResourceType> findAll();
}
