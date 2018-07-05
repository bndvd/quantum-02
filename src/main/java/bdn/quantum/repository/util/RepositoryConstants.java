package bdn.quantum.repository.util;

import java.util.HashMap;
import java.util.Map;

public final class RepositoryConstants {

	private static Map<String, Map<Integer, String>> columnMap;
	// Transaction table
	public static final String TABLE_TRANSACTION = "transaction";
	// column positions in transaction table
	public static final Integer POS_TRANSACTION_TRAN_ID = 0;
	public static final Integer POS_TRANSACTION_SEC_ID = 1;
	public static final Integer POS_TRANSACTION_USER_ID = 2;
	public static final Integer POS_TRANSACTION_TRAN_DATE = 3;
	public static final Integer POS_TRANSACTION_TRAN_TYPE = 4;
	public static final Integer POS_TRANSACTION_TRAN_SHARES = 5;
	public static final Integer POS_TRANSACTION_TRAN_PRICE = 6;

	private static final String TRANSACTION_TRAN_ID = "tranId";
	private static final String TRANSACTION_SEC_ID = "secId";
	private static final String TRANSACTION_USER_ID = "userId";
	private static final String TRANSACTION_TRAN_DATE = "tranDate";
	private static final String TRANSACTION_TRAN_TYPE = "type";
	private static final String TRANSACTION_TRAN_SHARES = "shares";
	private static final String TRANSACTION_TRAN_PRICE = "price";
	
	{
		init();
	}
	
	private static void init() {
		columnMap = new HashMap<>();
		
		Map<Integer, String> transactionColumnMap = new HashMap<>();
		transactionColumnMap.put(POS_TRANSACTION_TRAN_ID, TRANSACTION_TRAN_ID);
		transactionColumnMap.put(POS_TRANSACTION_SEC_ID, TRANSACTION_SEC_ID);
		transactionColumnMap.put(POS_TRANSACTION_USER_ID, TRANSACTION_USER_ID);
		transactionColumnMap.put(POS_TRANSACTION_TRAN_DATE, TRANSACTION_TRAN_DATE);
		transactionColumnMap.put(POS_TRANSACTION_TRAN_TYPE, TRANSACTION_TRAN_TYPE);
		transactionColumnMap.put(POS_TRANSACTION_TRAN_SHARES, TRANSACTION_TRAN_SHARES);
		transactionColumnMap.put(POS_TRANSACTION_TRAN_PRICE, TRANSACTION_TRAN_PRICE);
		
		columnMap.put(TABLE_TRANSACTION, transactionColumnMap);
	}
	
	public static String getColumnName(String table, Integer columnPosition) {
		System.out.println("RepositoryConstants.getColumnName() table:"+table+" colPos:"+columnPosition);
		return columnMap.get(table).get(columnPosition);
	}
}
