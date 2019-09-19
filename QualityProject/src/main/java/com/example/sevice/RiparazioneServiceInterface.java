package com.example.sevice;


import java.util.List;

import com.example.model.Product;
import com.example.model.Riparazione;

public interface RiparazioneServiceInterface {
	
	public Riparazione createRiparazione( Product product,String nota);
	
	public Riparazione findLastByTarget(String target);
	
	public List<Riparazione> findAllByTarget(String target);
	
	public String findNotaByTarget(String target);
	
	public Riparazione updateRipLastProduct(String target);

}
