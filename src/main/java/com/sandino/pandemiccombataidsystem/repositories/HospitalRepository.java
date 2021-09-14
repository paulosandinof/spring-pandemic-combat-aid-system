package com.sandino.pandemiccombataidsystem.repositories;

import com.sandino.pandemiccombataidsystem.entities.Hospital;

import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, String> {

}
