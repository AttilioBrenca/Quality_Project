package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Product;

@Transactional
public interface ProductDao extends CrudRepository<Product, String> {
	
	
	@Query(value = "select * from prodotto where tag = ?1",nativeQuery = true)
	public Product findByTarget(String target);
	
	public List<Product> findByQualita(int qualita);
	
	public List<Product> findByNome(String nome);
	
	//@Query(value=" update prodotto set qualita = ?2 where target = ?1",nativeQuery = true)
	//public void updateQuality(String target, int quality);
	
	//@Query(value=" update prodotto set nome = ?2 where target = ?1",nativeQuery = true)
	//public void updateName(String target, String name);
	
	
	

}
