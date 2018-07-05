package bdn.quantum.service;

import java.util.List;

import bdn.quantum.model.Transaction;

public interface TransactionService {
	
	List<Transaction> getTransactions(Integer userId);
	Transaction getTransaction(Integer tranId);
	Transaction createTransaction(Transaction transaction);
	
}
