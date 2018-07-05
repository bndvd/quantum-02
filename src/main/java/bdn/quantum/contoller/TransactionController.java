package bdn.quantum.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bdn.quantum.model.Transaction;
import bdn.quantum.service.TransactionService;

@RestController
@RequestMapping("api/v1/")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/transactions/{userId}", method = RequestMethod.GET)
	public List<Transaction> getTransactions(@PathVariable(value="userId") Integer userId) {
		System.out.println("TransactionController.getTransactions: userId=" + userId);
		return transactionService.getTransactions(userId);
	}
}
