package com.example;
 
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;  
import org.junit.Test;
import org.junit.runner.RunWith;
import  org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.model.Product;
import com.example.model.ProductDetails;
import com.example.model.Riparazione;
import com.example.sevice.ProductDetailsService;
import com.example.sevice.ProductService;
import com.example.sevice.RiparazioneService;
@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class TestController {
 
	//=====================================================PRODOTTO==============================================
		@Test
		public void createprodotto() throws Exception {
		String tag="asdfgh3";
		ProductService prodottoS = mock(ProductService.class);
			when(prodottoS.createProduct(tag)).thenReturn(new Product(tag));
		}
		//=====================================================Prodotto dettagli==============================================
			@Test
			public void createDetailsProduct() throws Exception {
				String descrizione="borsa con pietre colorate e con corallo";
				String provenienza="milano";
				String categoria="borse";
				String tag="asdfgh3";
				Product prodotto= new Product(tag);
			
				ProductDetailsService pdservice = mock(ProductDetailsService.class);
				when(pdservice.createProductDetails(categoria, descrizione, provenienza, prodotto)).thenReturn(new ProductDetails());
						}
		//=====================================================Riparazione==============================================
		@Test
		public void createRiparazione() throws Exception {
			String nota="cerniera non cucita bene";
			String tag="asdfgh3";
			Product findProductbytarget= new Product(tag);
		
	    RiparazioneService riparazione = mock(RiparazioneService.class);
			when(riparazione.createRiparazione(findProductbytarget, nota)).thenReturn(new Riparazione());
		}
	
}