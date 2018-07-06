package bdn.quantum.controller;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import bdn.quantum.model.TranEntity;
import bdn.quantum.util.PortfolioConstants;

public class TransactionControllerTest {
	
	@Test(timeout = 10000)
	public void testGetTransactions() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<TranEntity>> transactionResponse = restTemplate.exchange(
				"http://localhost:8080/quantum-02/api/v1/transactions/1", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TranEntity>>() {
				});
		List<TranEntity> transactions = transactionResponse.getBody();

		for (TranEntity t : transactions) {
			System.out.println("Transaction: " + t.toString());
		}
	}
	
	@Test(timeout = 10000)
	public void testGetTransaction() {
		RestTemplate restTemplate = new RestTemplate();

		TranEntity t = restTemplate.getForObject("http://localhost:8080/quantum-02/api/v1/transaction/1", TranEntity.class);

		System.out.println("Get transaction: " + t);
	}

	@SuppressWarnings("deprecation")
	@Test(timeout = 10000)
	public void testCreateTransaction() {
		RestTemplate restTemplate = new RestTemplate();

		TranEntity t = new TranEntity();
		t.setSecId(1);
		t.setUserId(1);
		t.setTranDate(new Date(118, 3, 5));
		t.setType(PortfolioConstants.TYPE_SELL);
		t.setShares(1.0);
		t.setPrice(61.53);
		
		t = restTemplate.postForObject("http://localhost:8080/quantum-02/api/v1/transaction", t, TranEntity.class);
	}

}
