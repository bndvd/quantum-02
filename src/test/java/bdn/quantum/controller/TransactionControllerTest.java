package bdn.quantum.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import bdn.quantum.model.Transaction;

public class TransactionControllerTest {

	@Test(timeout = 3000)
	public void testGetTransactions() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Transaction>> transactionResponse = restTemplate.exchange(
				"http://localhost:8080/quantum-02-jpa/api/v1/transactions/1", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Transaction>>() {
				});
		List<Transaction> transactions = transactionResponse.getBody();

		for (Transaction t : transactions) {
			System.out.println("Transaction: " + t.toString());
		}
	}

}
