package com.sandino.pandemiccombataidsystem.controllers;

import java.util.List;

import com.sandino.pandemiccombataidsystem.dtos.HospitalDTO;
import com.sandino.pandemiccombataidsystem.dtos.OccupationPercentageDTO;
import com.sandino.pandemiccombataidsystem.entities.Hospital;
import com.sandino.pandemiccombataidsystem.services.HospitalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public List<Hospital> index() {
        return hospitalService.list();
    }

    @PostMapping
    public Hospital store(@RequestBody HospitalDTO hospitalDTO) {
        System.out.println(hospitalDTO);
        return hospitalService.create(hospitalDTO);
    }

    @GetMapping(path = "{hospitalId}")
    public Hospital show(@PathVariable("hospitalId") String hospitalId) {
        return hospitalService.retrieve(hospitalId);
    }

    @PatchMapping(path = "{hospitalId}")
    public Hospital update(@PathVariable("hospitalId") String hospitalId,
            @RequestBody OccupationPercentageDTO occupationPercentageDTO) {
        return hospitalService.updateOccupationPercentage(hospitalId, occupationPercentageDTO);
    }
}
