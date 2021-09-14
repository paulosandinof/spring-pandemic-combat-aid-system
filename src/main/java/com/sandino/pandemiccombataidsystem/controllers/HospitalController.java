package com.sandino.pandemiccombataidsystem.controllers;

import com.sandino.pandemiccombataidsystem.dtos.HospitalDTO;
import com.sandino.pandemiccombataidsystem.entities.Hospital;
import com.sandino.pandemiccombataidsystem.services.HospitalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    private HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    public Hospital store(@RequestBody HospitalDTO hospitalDTO) {

        return hospitalService.create(hospitalDTO);

    }

}
