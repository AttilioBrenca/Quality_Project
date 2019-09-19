package com.example.sevice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.RiparazioneDao;
import com.example.model.Product;
import com.example.model.Riparazione;

@Component
public class RiparazioneService implements RiparazioneServiceInterface {

	@Autowired
	RiparazioneDao riparazioneDao;
	
	@Override
	public Riparazione createRiparazione(Product product,String nota) {
		
		Riparazione repair = new Riparazione(product,nota);
		riparazioneDao.save(repair);
		
		return repair;
		
				
	}

	@Override
	public Riparazione findLastByTarget(String target) {
		List<Riparazione> listRepair = riparazioneDao.findByTargetDesc(target);
		return listRepair.get(0);
	}

	@Override
	public List<Riparazione> findAllByTarget(String target) {
		List<Riparazione> listRepair = riparazioneDao.findByTargetDesc(target);
		return listRepair;
	}
	
	//Questo metodo restituisce la nota del'ultimo prodotto inserito con quel target
	public String findNotaByTarget(String target) {
		Riparazione repair = findLastByTarget(target);
		return repair.getNota();
	}
	
	//modifica la data dell'ultimo prodotto in riparazione che corrisponde a quel target
	public Riparazione updateRipLastProduct(String target) {
		Riparazione repair = findLastByTarget(target);
		repair.setDataFine(LocalDate.now());
		riparazioneDao.save(repair);
		return repair;
	}
	
	//Elimina la riparazione per quel prodotto

	
	
	
	
	

}
