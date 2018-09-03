package bdn.quantum.controller;

import java.io.IOException;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import bdn.quantum.model.BasketEntity;
import bdn.quantum.model.PortfolioData;
import bdn.quantum.model.SecurityEntity;
import bdn.quantum.model.TranEntity;

public class PortfolioControllerTest {

	@Test(timeout = 10000)
	public void testGetPortfolioData() {
		RestTemplate restTemplate = new RestTemplate();

		PortfolioData p = restTemplate.getForObject("http://localhost:8080/quantum-02/api/v1/portfolioData", PortfolioData.class);

		System.out.println("--- Portfolio Start ---");
		for (BasketEntity b : p.getBasketEntities()) {
			System.out.println("Basket: " + b.toString());
		}
		for (SecurityEntity s : p.getSecurityEntities()) {
			System.out.println("Security: " + s.toString());
		}
		for (TranEntity t : p.getTranEntities()) {
			System.out.println("Transaction: " + t.toString());
		}
		System.out.println("--- Portfolio End ---");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
            // get PortfolioData object as a json string
            String jsonStr = mapper.writeValueAsString(p);
            System.out.println(jsonStr);
        }
		catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Test(timeout = 10000)
	public void testAddPortfolioData() {
		//String jsonString = "{\"basketEntities\":[{\"basketId\":1,\"name\":\"AAPL\"},{\"basketId\":2,\"name\":\"TotStockMkt\"}],\"securityEntities\":[{\"secId\":1,\"basketId\":1,\"symbol\":\"AAPL\"},{\"secId\":2,\"basketId\":2,\"symbol\":\"VTI\"},{\"secId\":3,\"basketId\":2,\"symbol\":\"VTSAX\"}],\"tranEntities\":[{\"tranId\":1,\"secId\":1,\"userId\":1,\"tranDate\":1518415200000,\"type\":\"BUY\",\"shares\":5.0,\"price\":56.2},{\"tranId\":2,\"secId\":1,\"userId\":1,\"tranDate\":1518501600000,\"type\":\"BUY\",\"shares\":5.0,\"price\":56.42},{\"tranId\":3,\"secId\":1,\"userId\":1,\"tranDate\":1518415200000,\"type\":\"BUY\",\"shares\":5.0,\"price\":56.24},{\"tranId\":4,\"secId\":1,\"userId\":1,\"tranDate\":1521781200000,\"type\":\"SEL\",\"shares\":11.0,\"price\":59.83},{\"tranId\":5,\"secId\":1,\"userId\":1,\"tranDate\":1522904400000,\"type\":\"SEL\",\"shares\":1.0,\"price\":61.53},{\"tranId\":11,\"secId\":1,\"userId\":1,\"tranDate\":1530939600000,\"type\":\"BUY\",\"shares\":4.0,\"price\":62.2},{\"tranId\":6,\"secId\":2,\"userId\":1,\"tranDate\":1511157600000,\"type\":\"BUY\",\"shares\":50.0,\"price\":40.11},{\"tranId\":7,\"secId\":2,\"userId\":1,\"tranDate\":1512367200000,\"type\":\"BUY\",\"shares\":100.0,\"price\":39.8},{\"tranId\":8,\"secId\":2,\"userId\":1,\"tranDate\":1520229600000,\"type\":\"SEL\",\"shares\":20.0,\"price\":40.05},{\"tranId\":9,\"secId\":3,\"userId\":1,\"tranDate\":1486879200000,\"type\":\"BUY\",\"shares\":120.0,\"price\":21.63},{\"tranId\":10,\"secId\":3,\"userId\":1,\"tranDate\":1491022800000,\"type\":\"BUY\",\"shares\":28.0,\"price\":21.88}]}";
		String jsonString = "{\"basketEntities\":[{\"basketId\":4,\"name\":\"GE\"}],\"securityEntities\":[{\"secId\":5,\"basketId\":4,\"symbol\":\"GE\"},{\"secId\":7,\"basketId\":4,\"symbol\":\"GEHC\"}],\"tranEntities\":[{\"tranId\":11,\"secId\":4,\"userId\":1,\"tranDate\":1518415200000,\"type\":\"BUY\",\"shares\":12.0,\"price\":23.56}]}";
		
		PortfolioData p = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			p = mapper.readValue(jsonString, PortfolioData.class);
        }
		catch (Exception e) {
            e.printStackTrace();
        }
		
		if (p != null) {
			RestTemplate restTemplate = new RestTemplate();
			p = restTemplate.postForObject("http://localhost:8080/quantum-02/api/v1/portfolioData", p, PortfolioData.class);
			System.out.println("Portfolio Data Added successfully");
		}
		else {
			System.out.println("Portfolio Data NOT Added successfully");
		}
	}
	
}
