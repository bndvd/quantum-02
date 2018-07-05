package bdn.quantum.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/transaction/{tranId}", method = RequestMethod.GET)
	public Transaction getTransaction(@PathVariable(value="tranId") Integer tranId) {
		System.out.println("TransactionController.getTransaction: tranId=" + tranId);
		return transactionService.getTransaction(tranId);
	}

	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		System.out.println("TransactionController.createTransaction: transaction=" + transaction);
		return transactionService.createTransaction(transaction);
	}

}
