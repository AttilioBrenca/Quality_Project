package com.example.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.ProductDao;
import com.example.model.Product;

@Component
public class ProductService implements ProductServiceInterface {
	
	@Autowired
	ProductDao productDao;

	@Override
	public Product createProduct(String target) {
		
		Product product = new Product(target);
		productDao.save(product);
		
		return product;
		
	}

	@Override
	public Product findProductByTarget(String target) {
		
		Product product = productDao.findByTarget(target);
		return product;
	}
	

	@Override
	public List<Product> findProductsByQuality(int quality) {
		
		List<Product> products = productDao.findByQualita(quality);
		return products;
	}
	
	@Override
	public List<Product> findProductsByNome(String nome) {
		
		List<Product> products = productDao.findByNome(nome);
		return products;
	}
	
	public List<Product> findAllProducts(){
		List<Product> products = (List<Product>) productDao.findAll();
		return products;
	}

	@Override
	public Product setNome(String target,String name) {
		//Prendo il prodotto che ha quel target e gli setto il nome
		Product p = findProductByTarget(target);
		p.setNome(name);
		productDao.save(p);
		return p;
		
		
	}
	@Override
	public Product setQuality(String target,int quality) {
		Product p = findProductByTarget(target);
		p.setQualita(quality);
		productDao.save(p);
		return p;
	}
	
	

}
