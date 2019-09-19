package com.example.controllers;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.sevice.ProductDetailsService;
import com.example.sevice.ProductService;
import com.example.sevice.RiparazioneService;
import com.example.model.Product;
import com.example.model.ProductDetails;
import com.example.model.Riparazione;


@RestController
@RequestMapping("/products")
public class RController {
	
	//============
	//   GET
	//============
	
	//Restituisce tutti i prodotti nel db
	@GetMapping
	public List<Product> getAll(){
		return productService.findAllProducts();
	 
	}
	
	//Mi restituisce il prodotto con un certo id
	@GetMapping("/tag/{tag}")
	public Product getById(@PathVariable("tag") String tag) {
		return productService.findProductByTarget(tag);
	}
	
	//Mi restituisce una lista di prodotti che hanno un certo nome
	@GetMapping("/name/{name}")
	public List<Product> getByName(@PathVariable("name") String name) {
		return productService.findProductsByNome(name);
	}
	
	//Mi restituisce una lista di prodotti che hanno un certo nome
	@GetMapping("/quality/{quality}")
	public List<Product> getByQuality(@PathVariable("quality") int quality){
		return productService.findProductsByQuality(quality);
	}
	
	//============
	//   CREATE
	//============
	
	//Crea un prodotto dato un target
	@PostMapping(path="/create")
	public Product createProduct(@RequestParam(name = "target",required=false) String target) {
		return productService.createProduct(target);
		
	}
	
	//============
	//   UPDATE
	//============
	
	//Modifica il nome di un prodotto con un certo target
	@PutMapping(path="/update/name/{target}")
	public Product updateProductName(
			@RequestParam(name = "name",required=false) 
			String name,
			@PathVariable("target")
			String target
			) 
	{
		return productService.setNome(target, name);
		
	}

	//Modifica la qualità di un prodotto con unc erto target
	@PutMapping(path="/update/quality/{target}")
	public Product updateProductQuality(
			@RequestParam(name = "quality",required=false) 
			String quality,
			@PathVariable("target")
			String target
			) 
	{
		return productService.setQuality(target, Integer.parseInt(quality));
		
	}

	//===============
	//PRODUCT DETAILS
	//   CREATE
	//===============
	
	//Inserisce i dettagli del prodotto dato il target di quest ultimo
	@PostMapping(path="/create/details")
	public ProductDetails createDetailsProduct(
			@RequestParam(name = "cat",required=false)
			String category,
			@RequestParam(name = "descr",required=false)
			String description,
			@RequestParam(name = "prov",required=false)
			String provenance,
			@RequestParam(name = "target",required=false) 
			String tagProduct) {
		
		return productDetailsService.createProductDetails(category, description, provenance, productService.findProductByTarget(tagProduct));
		
	}
	
	//================================
	// 			REPAIRS
	//================================
	
	//=============
	//    CREATE
	//=============
	@PostMapping(path="/create/repair")
	public Riparazione createRiparazione(
			@RequestParam(name = "note",required=false)
			String nota,
			@RequestParam(name = "target",required=false) 
			String tagProduct
			) {
		
		return riparazioneService.createRiparazione(productService.findProductByTarget(tagProduct), nota);
	}
	
	//=========
	//   GET
	//=========
	
	
	//Trova l'ultima riparazione per quel prodotto
	@GetMapping("/repair/target/{target}")
	public Riparazione getLastByTag(@PathVariable("target")String target) {
		return riparazioneService.findLastByTarget(target);
	}
	
	//Trova tutte le riparazioni per un dato prodotto
	@GetMapping("/repairs/target/{target}")
	public List<Riparazione> getByTag(@PathVariable("target")String target) {
		return riparazioneService.findAllByTarget(target);
	}
	
	//Trova la nota per l'ultima riparazione di un dato prodotto
	@GetMapping("/repair/notes/target/{target}")
	public String getNoteByTarget(@PathVariable("target")String target) {
		return riparazioneService.findNotaByTarget(target);
	}
	
	//============
	//   UPDATE
	//============
	
	@PutMapping(path="/repair/update/date")
	public Riparazione updateLastDate(@RequestParam(name="target",required=false)String target) {
		
		return riparazioneService.updateRipLastProduct(target);
		
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE").allowedOrigins("*")
	 .allowedHeaders("*");
}
		};
	}
	
	
	
	
	
 	@Autowired
 	private ProductService productService;
	
 	@Autowired
 	private ProductDetailsService productDetailsService;
	
	@Autowired
	private RiparazioneService riparazioneService;
	

}
