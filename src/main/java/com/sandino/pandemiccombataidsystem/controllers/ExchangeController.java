package com.sandino.pandemiccombataidsystem.controllers;

import java.util.List;

import com.sandino.pandemiccombataidsystem.dtos.HospitalExchangeDTO;
import com.sandino.pandemiccombataidsystem.entities.Exchange;
import com.sandino.pandemiccombataidsystem.services.ExchangeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchanges")
public class ExchangeController {

    private ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping
    public List<Exchange> store(@RequestBody HospitalExchangeDTO hospitalExchangeDTO) {
        return exchangeService.exchangeResources(hospitalExchangeDTO);
    }
}