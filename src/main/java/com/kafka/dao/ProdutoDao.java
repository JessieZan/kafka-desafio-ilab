package com.kafka.dao;

import com.kafka.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDao extends CrudRepository<Produto, Integer> {

}
