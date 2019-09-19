package com.example.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.ProductDetailsDao;
import com.example.model.Product;
import com.example.model.ProductDetails;

@Component
public class ProductDetailsService implements ProductDetailsServiceInterface {

	@Autowired
	ProductDetailsDao productDetailsDao;
	
	@Override
	public ProductDetails createProductDetails(String category, String description, String provenance,
			Product product) {
		
		ProductDetails productDetails = new ProductDetails(category,description,
				provenance,product);
		productDetailsDao.save(productDetails);
		
		return productDetails;
	}
	
	@Override
	public void deleteProduct(long id) {
		productDetailsDao.deleteById(id);
	}

	@Override
	public ProductDetails findByProduct(Product p) {
		
		return productDetailsDao.findByProduct(p.getTag());
	}

	@Override
	public List<ProductDetails> findAllProductDetails() {

		List<ProductDetails> list = ( List<ProductDetails> ) productDetailsDao.findAll();
		return list;
	}

}
