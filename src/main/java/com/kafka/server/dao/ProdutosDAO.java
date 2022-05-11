package com.kafka.server.dao;

import com.kafka.server.models.Produto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosDAO extends CrudRepository<Produto, Integer> {
}


