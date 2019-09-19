package com.example.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.ProductDetails;

@Transactional
public interface ProductDetailsDao extends CrudRepository<ProductDetails, Long> {

	@Query(value="select * from dettagli_prodotto where prodotto = ?1",nativeQuery = true)
	public ProductDetails findByProduct(String target);
	
	
}
