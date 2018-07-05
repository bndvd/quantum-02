package bdn.quantum.repository;

import java.util.List;

import bdn.quantum.model.Transaction;

public interface TransactionRepository {

	List<Transaction> getTransactions(Integer userId);
	Transaction createTransaction(Transaction transaction);
	Transaction getTransaction(Integer tranId);
	
}
