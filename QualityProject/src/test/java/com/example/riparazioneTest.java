package com.example; 
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import com.example.model.Product;
import com.example.model.Riparazione; 
public class riparazioneTest {
	private Riparazione riparazione;
	@Before
	public void setUp() throws Exception {
		riparazione = new Riparazione();
		  return;
	}
	@Test
	public void createriparazione() {
		 LocalDate today = LocalDate.now();
		 LocalDate data = LocalDate.now();
		 Product Prod = new Product();
		 riparazione.setId(0);
		 riparazione.setProduct(Prod);
		 riparazione.setNota("Cerniera non cucita correttamente");
		 riparazione.setDataInvioRiparazione(today);
		 riparazione.setDataFine(data);
	}
	@Test
	public void findbytag() {
		riparazione.setId(0);
	}
	@Test
	public void findtbyRiparazione() {
		riparazione.setId(0);
	}
	@Test
	public void Deleterip() {
		riparazione.setId(0);
	}
}