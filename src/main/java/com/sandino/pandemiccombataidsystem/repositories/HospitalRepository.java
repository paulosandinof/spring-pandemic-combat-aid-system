package com.sandino.pandemiccombataidsystem.repositories;

import java.util.List;

import com.sandino.pandemiccombataidsystem.entities.Hospital;

import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, String> {
    List<Hospital> findAll();
}
