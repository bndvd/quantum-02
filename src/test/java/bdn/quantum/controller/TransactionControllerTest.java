package bdn.quantum.controller;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import bdn.quantum.model.PortfolioConstants;
import bdn.quantum.model.Transaction;

public class TransactionControllerTest {
	
	@Test(timeout = 10000)
	public void testGetTransactions() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Transaction>> transactionResponse = restTemplate.exchange(
				"http://localhost:8080/quantum-02/api/v1/transactions/1", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Transaction>>() {
				});
		List<Transaction> transactions = transactionResponse.getBody();

		for (Transaction t : transactions) {
			System.out.println("Transaction: " + t.toString());
		}
	}
	
	@Test(timeout = 10000)
	public void testGetTransaction() {
		RestTemplate restTemplate = new RestTemplate();

		Transaction t = restTemplate.getForObject("http://localhost:8080/quantum-02/api/v1/transaction/1", Transaction.class);

		System.out.println("Get transaction: " + t);
	}

	@SuppressWarnings("deprecation")
	@Test(timeout = 10000)
	public void testCreateTransaction() {
		RestTemplate restTemplate = new RestTemplate();

		Transaction t = new Transaction();
		t.setSecId(1);
		t.setUserId(1);
		t.setTranDate(new Date(2018, 1, 12));
		t.setType(PortfolioConstants.TYPE_BUY);
		t.setShares(5.0);
		t.setPrice(56.24);
		
		t = restTemplate.postForObject("http://localhost:8080/quantum-02/api/v1/transaction", t, Transaction.class);
	}

}
