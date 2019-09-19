package com.example.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dettagli_prodotto")
public class ProductDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5162355791992440150L;

	@Id
	@GeneratedValue(generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "data_registrazione")
	private LocalDate date;
	
	@Column(name = "categoria")
	private String category;
	
	@Column(name = "descrizione")
	private String description;
	
	@Column(name = "provenienza")
	private String provenance;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "prodotto")
	private Product product;
	
	public ProductDetails() {
		
		this.date = LocalDate.now();
	}

	public ProductDetails(  String category, String description, String provenance,
			Product product) {
		this();
		this.category = category;
		this.description = description;
		this.provenance = provenance;
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProvenance() {
		return provenance;
	}

	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", date=" + date + ", category=" + category + ", description=" + description
				+ ", provenance=" + provenance + ", product=" + product + "]";
	}
}
