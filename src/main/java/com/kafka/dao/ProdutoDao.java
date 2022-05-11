package com.kafka.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kafka.model.Produto;

@Repository
public interface ProdutoDao extends CrudRepository<Produto, Integer>{
	
}
