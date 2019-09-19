package com.example.sevice;

import java.util.List;

import com.example.model.Product;

public interface ProductServiceInterface {
	
	public Product createProduct(String target);
	
	public Product findProductByTarget(String target);
	
	//Questo metodo viene utilizzato per inserire il nome del prodotto una volta che questo 
	//è stato creato
	public Product setNome(String target,String name);
	
	public List<Product> findProductsByQuality(int quality);
	
	public List<Product> findAllProducts();

	public Product setQuality(String target, int quality);

	List<Product> findProductsByNome(String nome);
	


}
