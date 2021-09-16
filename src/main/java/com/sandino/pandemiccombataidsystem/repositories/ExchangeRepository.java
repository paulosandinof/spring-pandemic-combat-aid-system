package com.sandino.pandemiccombataidsystem.repositories;

import java.util.List;

import com.sandino.pandemiccombataidsystem.entities.Exchange;

import org.springframework.data.repository.CrudRepository;

public interface ExchangeRepository extends CrudRepository<Exchange, String> {
    List<Exchange> findAll();
}
