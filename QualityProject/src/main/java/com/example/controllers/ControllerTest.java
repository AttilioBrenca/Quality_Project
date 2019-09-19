package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody; 
import com.example.model.Product;
import com.example.model.ProductDetails;
import com.example.model.Riparazione;
import com.example.sevice.ProductDetailsService;
import com.example.sevice.ProductService;
import com.example.sevice.RiparazioneService;

import exception.Exep;

@Controller
public class ControllerTest {
	

	@ResponseBody
	@RequestMapping(value="/create-product")
	public String createProduct(
			@RequestParam(name = "target",required = false)
			String target
			) throws Exep {
		 if ( productService.findProductByTarget(target)!=null) {
			throw new Exep("prodotto non esistente");
 		}
		else {
		/*	Product newProduct = */productService.createProduct(target);
		}
		return "Prodotto creato:" +target;
	}
	@ResponseBody
	@RequestMapping(value="/update-product")
	public String updateProduct(
			@RequestParam(name = "target",required = false)
			String target,
			@RequestParam(name = "name",required = false)
			String name,
			@RequestParam(name = "quality",required = false)
			String quality
			
			) 
			throws Exep {
		
		if((Integer.parseInt(quality)<1)||(Integer.parseInt(quality)>3))
			 throw new Exep("qualità deve essere compresa tra 1 e 3");
	  else {
	  	productService.setNome(target, name);
		productService.setQuality(target, Integer.parseInt(quality));
	  }
		return "Prodotto modificato";
	 }
	@ResponseBody
	@RequestMapping(value="/create-product-details")
	public String createProductDetails(
			@RequestParam(name = "target",required=false)
			String target,
			@RequestParam(name = "category", required=false)
			String category
			
			) 
	{
		Product product = productService.findProductByTarget(target);
		ProductDetails productDetails = productDetailsService.createProductDetails(category, null, null, product);
		
		return "Creato product details: "+ productDetails.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/create-repair")
	public String createRepair(
			@RequestParam(name = "target")
			String target,
			@RequestParam(name = "nota")
			String nota
			)
	{
		Product product = productService.findProductByTarget(target);
		Riparazione repair = riparazioneService.createRiparazione(product,nota);
		
		return "Creata riparazione: "+ repair.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/get-repair")
	public String getRepair(
			@RequestParam(name = "target")
			String target
			) 
	{
		Riparazione repair = riparazioneService.findLastByTarget(target);
		
		return repair.toString();
		
	}
	
	@ResponseBody
	@RequestMapping(value="/update-repair")
	public String updateRepair(
			@RequestParam(name = "target")
			String target
			)
	{
		riparazioneService.updateRipLastProduct(target);
		
		return "Data riparazione modificata!";
	}
	
	@ResponseBody
	@RequestMapping(value="/get-note-repair")
	public String getNote(
			@RequestParam(name = "target")
			String target
			)
	{
		String nota = riparazioneService.findNotaByTarget(target);
		
		return nota;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/delete-product")
	public String deleteProduct(
			@RequestParam(name ="id", required=false)
			String id
			) 
	{
		long dId = Long.parseLong(id);
		productDetailsService.deleteProduct(dId);
		
		return "Benvenuto!";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/contents/products")
	public String getProducts() {
		String strProducts = "";
		List<Product> products = productService.findAllProducts();
		int i=1;
		for(Product p : products) {
			ProductDetails pD = productDetailsService.findByProduct(p);
			
			strProducts += "Prodotto: " +i+ " "+ p.toString() + "Dettagli: "+ pD.toString();
			i++;
		}

		return strProducts;
	}
	
	@ResponseBody
	@RequestMapping(value="/contents/details-products")
	public String getDetailsProduct()
	{
		String str ="";
		List<ProductDetails> list = productDetailsService.findAllProductDetails();
		for(ProductDetails pD : list) {
			str += pD.toString() + "\n";
		}
		return str;
	}
	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@Autowired
	private RiparazioneService riparazioneService;

}
