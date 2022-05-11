package com.kafka.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kafka.model.Pedido;

@Repository
public interface PedidoDao extends CrudRepository<Pedido, Integer>{

}
