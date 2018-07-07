package bdn.quantum.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import bdn.quantum.model.Asset;
import bdn.quantum.model.BasketEntity;
import bdn.quantum.model.Position;
import bdn.quantum.model.SecurityEntity;

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

	@Test(timeout = 10000)
	public void testGetSecurities() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<SecurityEntity>> transactionResponse = restTemplate.exchange(
				"http://localhost:8080/quantum-02/api/v1/securities", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<SecurityEntity>>() {
				});
		List<SecurityEntity> securities = transactionResponse.getBody();

		for (SecurityEntity s : securities) {
			System.out.println("Security: " + s.toString());
		}
	}
	
	@Test(timeout = 10000)
	public void testGetSecuritiesForBasket() {
		RestTemplate restTemplate = new RestTemplate();

		int basketId = 2;
		ResponseEntity<List<SecurityEntity>> transactionResponse = restTemplate.exchange(
				"http://localhost:8080/quantum-02/api/v1/securities/"+basketId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<SecurityEntity>>() {
				});
		List<SecurityEntity> securities = transactionResponse.getBody();

		for (SecurityEntity s : securities) {
			System.out.println("Security: " + s.toString());
		}
	}
	
	@Test(timeout = 10000)
	public void testCreateSecurity() {
		RestTemplate restTemplate = new RestTemplate();

		SecurityEntity s = new SecurityEntity(null, 1, "AAPL");
		
		restTemplate.postForEntity("http://localhost:8080/quantum-02/api/v1/security", s, SecurityEntity.class);	
	}

	@Test(timeout = 10000)
	public void testGetAssets() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Asset>> transactionResponse = restTemplate.exchange(
				"http://localhost:8080/quantum-02/api/v1/assets", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Asset>>() {
				});
		List<Asset> assets = transactionResponse.getBody();

		for (Asset a : assets) {
			System.out.println("Asset: " + a.toString());
		}
	}
	
	@Test(timeout = 10000)
	public void testGetPositions() {
		RestTemplate restTemplate = new RestTemplate();

		Integer basketId = 2;
		ResponseEntity<List<Position>> transactionResponse = restTemplate.exchange(
				"http://localhost:8080/quantum-02/api/v1/positions/"+basketId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Position>>() {
				});
		List<Position> positions = transactionResponse.getBody();

		for (Position p : positions) {
			System.out.println("Position: " + p.toString());
		}
	}
	
}
