package com.example;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import com.example.model.Product;
import com.example.model.ProductDetails; 
public class prodottodetTest {
	private ProductDetails productdet;
	@Before
	public void setUp() throws Exception {
		productdet = new ProductDetails();
		  return;
	}
	@Test
	public void createprodottodet() {
		 LocalDate data= LocalDate.now();
     Product Prod = new Product();
 		 productdet.setId(1);
		 productdet.setProduct(Prod);
		 productdet.setDescription(" Borsa con pietre patrizia pepe ");
		 productdet.setProvenance("MIlano");
		 productdet.setDate(data);
	}
	@Test
	public void deleteProduct() {
		productdet.setId(1);
	}
	@Test
	public void findbyProduct() {
	return;
	}
	@Test
	public void findbyProductdetails() {
		return;
	}
}