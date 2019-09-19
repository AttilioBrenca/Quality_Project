package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Riparazione;

@Transactional
public interface RiparazioneDao extends CrudRepository<Riparazione, Long> {
	
	@Query(value="select * from riparazione where prodotto=?1 order by data_invio_riparazione desc",nativeQuery = true)
	public List<Riparazione> findByTargetDesc(String target);
	
	
	

}
