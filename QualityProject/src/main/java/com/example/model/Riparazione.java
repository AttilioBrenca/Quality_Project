package com.example.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "riparazione")
public class Riparazione implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1219102707840980528L;

	@Id
	@GeneratedValue(generator="my_seq2")
	@SequenceGenerator(name="my_seq2",sequenceName="MY_SEQ2", allocationSize=1)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "data_invio_riparazione")
	private LocalDate dataInvioRiparazione;
	
	@Column(name = "data_fine")
	private LocalDate dataFine;
	
	@Column(name = "nota")
	private String nota;
	
	@ManyToOne
	@JoinColumn(name = "prodotto")
	private Product product;
	
	public Riparazione() {
		this.dataInvioRiparazione = LocalDate.now();
	}

	public Riparazione( Product product,String nota) {
		this();
		this.product = product;
		this.nota = nota;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDataInvioRiparazione() {
		return dataInvioRiparazione;
	}

	public void setDataInvioRiparazione(LocalDate dataInvioRiparazione) {
		this.dataInvioRiparazione = dataInvioRiparazione;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Riparazione [id=" + id + ", dataInvioRiparazione=" + dataInvioRiparazione + ", dataFine=" + dataFine
				+ ", product=" + product + "]";
	}
	
	
	
	
	
	
	
	

}
