package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="prodotto")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1066820375617277986L;

	@Id
	@Column(name = "tag")
	private String tag;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "qualita")
	private int qualita;
	
	public Product() {
		
	}
	
	public Product(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQualita() {
		return qualita;
	}

	public void setQualita(int qualita) {
		this.qualita = qualita;
	}

	@Override
	public String toString() {
		return "Product [tag=" + tag + ", nome=" + nome + ", qualita=" + qualita + "]";
	}
	
	
	

}
