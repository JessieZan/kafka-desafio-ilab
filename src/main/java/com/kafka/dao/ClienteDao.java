package com.kafka.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kafka.model.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Integer> {

}
