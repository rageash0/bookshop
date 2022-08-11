package bookshop.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bookshop.databaseconnection.DataAccessObject;

public class TransactionDetailsDao{
	
	private DataAccessObject database = new DataAccessObject();

	List<TransactionDetails> selectBySellerId(int sellerId){
		return selectAll("where sellerId='" +sellerId+ "'");
	}
	
	List<TransactionDetails> selectByBuyerId(int buyerId){
		return selectAll("where buyerid='" +buyerId+ "'");
	}
	
	List<TransactionDetails> selectAll(){
		return selectAll("");
	}
	
	//Helper method
	private List<TransactionDetails> selectAll(String condition){
		List<TransactionDetails> transactionList = new ArrayList<TransactionDetails>();
		
		try {
			Connection con = database.openConnection();
			ResultSet rs = con.createStatement()
								.executeQuery("select * from transaction " +condition);
			
			while(rs.next()) {
				TransactionDetails transactionDetails = new TransactionDetails(
																			rs.getInt(1),						//id
																			rs.getInt(2),						//bookid
																			rs.getLong(3),						//isbn
																			rs.getString(4),					//Book name	
																			rs.getString(5),					//author
																			rs.getString(6),					//edition
																			rs.getString(7),					//publisher
																			rs.getBigDecimal(8),				//price
																			rs.getInt(9),						//seller id
																			rs.getString(10),					//seller name
																			rs.getInt(11),						//buyer id
																			rs.getString(12),					//buyer name
																			rs.getInt(13),
																			rs.getString(14),
																			rs.getString(15),
																			rs.getString(16),
																			rs.getString(17),
																			LocalDateTime.parse(rs.getString(18)),
																			rs.getString(19),
																			rs.getString(20));
				
				transactionList.add(transactionDetails);
			}
			
			con.close();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return transactionList;
	}
	
	public boolean add(TransactionDetails transactionDetails) {
		
		try {
			
			Connection con = database.openConnection();
			PreparedStatement rs = con.prepareStatement("insert into transaction(bookid, "
																				+ "isbn, "
																				+ "bookname, "
																				+ "author, "
																				+ "edition, "
																				+ "publisher, "
																				+ "price, "
																				+ "sellerid, "
																				+ "sellername, "
																				+ "buyerid, "
																				+ "buyername, "
																				+ "houseno, "
																				+ "street, "
																				+ "city, "
																				+ "state, "
																				+ "country, "
																				+ "datetime, "
																				+ "payment, "
																				+ "delivery) "
																				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			rs.setInt(1, transactionDetails.getBookId());
			rs.setLong(2, transactionDetails.getIsbn());
			rs.setString(3, transactionDetails.getBookName());
			rs.setString(4, transactionDetails.getAuthor());
			rs.setString(5, transactionDetails.getEdition());
			rs.setString(6, transactionDetails.getPublisher());
			rs.setBigDecimal(7, transactionDetails.getPrice());
			rs.setInt(8, transactionDetails.getSellerId());
			rs.setString(9, transactionDetails.getSellerName());
			rs.setInt(10, transactionDetails.getBuyerId());
			rs.setString(11, transactionDetails.getBuyerName());
			rs.setInt(12, transactionDetails.getHouseNo());
			rs.setString(13, transactionDetails.getStreet());
			rs.setString(14, transactionDetails.getCity());
			rs.setString(15, transactionDetails.getState());
			rs.setString(16, transactionDetails.getCountry());
			rs.setString(17, transactionDetails.getDate().toString());
			rs.setString(18, transactionDetails.getPayment());
			rs.setString(19, transactionDetails.getDelivery());
			rs.executeUpdate();
			
			rs.close();
			con.close();
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public TransactionDetails selectByTransactionId(int id) {
		List<TransactionDetails> transactions = selectAll("where transactionid='" +id+ "'");
		
		if(transactions.isEmpty())
			return null;
		
		return transactions.get(0);
	}

	void setDeliveryStatus(String status, int id) {

		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			st.executeUpdate("update transaction set delivery='" +status+ "' where transactionid='" +id+ "'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}