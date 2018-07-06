package bdn.quantum.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import bdn.quantum.model.BasketEntity;

public class AssetControllerTest {
	
	@Test(timeout = 10000)
	public void testGetBaskets() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<BasketEntity>> transactionResponse = restTemplate.exchange(
				"http://localhost:8080/quantum-02/api/v1/baskets", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<BasketEntity>>() {
				});
		List<BasketEntity> baskets = transactionResponse.getBody();

		for (BasketEntity b : baskets) {
			System.out.println("Basket: " + b.toString());
		}
	}
	
	@Test(timeout = 10000)
	public void testCreateBasket() {
		RestTemplate restTemplate = new RestTemplate();

		BasketEntity b = new BasketEntity(null, "W3000");
		
		restTemplate.postForEntity("http://localhost:8080/quantum-02/api/v1/basket", b, BasketEntity.class);	
	}

}
