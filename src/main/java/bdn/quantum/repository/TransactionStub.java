package bdn.quantum.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import bdn.quantum.model.PortfolioConstants;
import bdn.quantum.model.Transaction;

@Repository
public class TransactionStub implements TransactionRepository {

	@Override
	public List<Transaction> getTransactions(Integer userId) {
		List<Transaction> transList = new ArrayList<>();
		
		Transaction t = new Transaction(1, 1, 1, new Date(), PortfolioConstants.TYPE_BUY, 5.0, 54.80);
		transList.add(t);
		t = new Transaction(2, 1, 1, new Date(), PortfolioConstants.TYPE_BUY, 15.0, 55.24);
		transList.add(t);
		t = new Transaction(3, 1, 1, new Date(), PortfolioConstants.TYPE_SELL, 2.0, 55.37);
		transList.add(t);
		
		return transList;
	}

}
