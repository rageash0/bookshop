package bookshop.transaction;

import java.util.List;

public class TransactionService {
	
	private TransactionDetailsDao transactionDetailsDao = new TransactionDetailsDao();
	private WholesaleTransactionDao wholesaleTransaction = new WholesaleTransactionDao();
	private WholesaleBookTransactionDao wholesaleBookTransactionDao = new WholesaleBookTransactionDao();
	
	public List<TransactionDetails> getBySellerId(int sellerId){
		return transactionDetailsDao.selectBySellerId(sellerId);
	}
	
	public List<TransactionDetails> getByBuyerId(int buyerId){
		return transactionDetailsDao.selectByBuyerId(buyerId);
	}
	
	public List<TransactionDetails> getAll(){
		return transactionDetailsDao.selectAll();
	}
	
	public boolean update(TransactionDetails transactionDetails) {
		return transactionDetailsDao.add(transactionDetails);
	}
	
	public boolean update(WholesaleTransactionDetails wholesaleTransactionDetails) {
		return wholesaleTransaction.addRecord(wholesaleTransactionDetails);
	}
	
	public boolean update(WholesaleBookTransactionDetails wholesaleBookTransactionDetails) {
		return wholesaleBookTransactionDao.addRecord(wholesaleBookTransactionDetails);
	}
	
	public List<WholesaleTransactionDetails> getWholesaleByBuyerId(int buyerId){
		return wholesaleTransaction.selectByBuyerId(buyerId);
	}
	
	public List<WholesaleTransactionDetails> getWholesaleBySellerId(int sellerId){
		return wholesaleTransaction.selectBySellerId(sellerId);
	}

	public TransactionDetails getByTransactionId(int id) {
		return transactionDetailsDao.selectByTransactionId(id);
	}

	public WholesaleTransactionDetails getByWholesaleTransactionId(int id) {
		return wholesaleTransaction.selectByWholesaleTransactionId(id);
	}

	public void setBookDeliveryStatus(String status, int id) {
		transactionDetailsDao.setDeliveryStatus(status, id);	
	}

	public void setWholesaleDeliveryStatus(String status, int id) {
		wholesaleTransaction.setDeliveryStatus(status, id);
	}

	public List<WholesaleTransactionDetails> getAllWholesale() {
		return wholesaleTransaction.selectAll();
	}
}
