package com.kafka.dao;

import com.kafka.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDao extends CrudRepository<Pedido, Integer> {

}
