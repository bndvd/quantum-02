package bdn.quantum.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import bdn.quantum.model.PortfolioConstants;
import bdn.quantum.model.Transaction;

public class TransactionStub implements TransactionRepository {

	@Override
	public List<Transaction> getTransactions(Integer userId) {
		List<Transaction> transList = new ArrayList<>();
		
		Transaction t = new Transaction(1, 1, 1, new Date(2018, 01, 12), PortfolioConstants.TYPE_BUY, 5.0, 54.80);
		transList.add(t);
		t = new Transaction(2, 1, 1, new Date(2018, 01, 15), PortfolioConstants.TYPE_BUY, 15.0, 55.24);
		transList.add(t);
		t = new Transaction(3, 1, 1, new Date(2018, 01, 16), PortfolioConstants.TYPE_SELL, 2.0, 55.37);
		transList.add(t);
		
		return transList;
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getTransaction(Integer tranId) {
		// TODO Auto-generated method stub
		return null;
	}

}
