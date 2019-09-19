package com.example.sevice;

import java.util.List;

import com.example.model.Product;
import com.example.model.ProductDetails;

public interface ProductDetailsServiceInterface {
	
	public ProductDetails createProductDetails(String category, String description, String provenance,
			Product product);
	
	public void deleteProduct(long id);
	
	public ProductDetails findByProduct(Product p);
	
	public List<ProductDetails> findAllProductDetails();
	
}
