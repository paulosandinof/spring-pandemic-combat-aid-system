package com.sandino.pandemiccombataidsystem.repositories;

import com.sandino.pandemiccombataidsystem.entities.Resource;

import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, String> {
}
