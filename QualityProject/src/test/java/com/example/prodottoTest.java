package com.example;
import org.junit.Before;
import org.junit.Test;

import com.example.model.Product;
public class prodottoTest {
	private Product product;
	@Before
	public void setUp() throws Exception {
		  product = new Product();
		  return;
	}
	@Test
	public void createprodotto() {
	product.setTag("ad323");	 
	product.setNome("Gucci");
	product.setQualita(1);
	}
	@Test
	public void findProductbytarget() {
		product.setTag("ad323");
	}
	@Test
	public void findProductbyQuality() {
		product.setQualita(1);
	}
	@Test
	public void findAllProducts() {
		return;
	}

}
