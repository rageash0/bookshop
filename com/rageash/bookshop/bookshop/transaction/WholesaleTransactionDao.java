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

public class WholesaleTransactionDao {

	private DataAccessObject database = new DataAccessObject();
	
	boolean addRecord(WholesaleTransactionDetails wholesaleTransactionDetails) {
		
		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into wholesaletransaction(wholesaleid, "
																						+ "wholesalename, "
																						+ "wholesaledescription, "
																						+ "isbn, "
																						+ "bookname, "
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
																						+ "date, "
																						+ "payment, "
																						+ "delivery) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			st.setInt(1, wholesaleTransactionDetails.getWholesaleId());
			st.setString(2, wholesaleTransactionDetails.getWholesaleName());
			st.setString(3, wholesaleTransactionDetails.getWholesaleDescription());
			st.setString(4, wholesaleTransactionDetails.getIsbn());
			st.setString(5, wholesaleTransactionDetails.getBookName());
			st.setBigDecimal(6, wholesaleTransactionDetails.getPrice());
			st.setInt(7, wholesaleTransactionDetails.getSellerId());
			st.setString(8, wholesaleTransactionDetails.getSellerName());
			st.setInt(9, wholesaleTransactionDetails.getBuyerId());
			st.setString(10, wholesaleTransactionDetails.getBuyerName());
			st.setInt(11, wholesaleTransactionDetails.getHouseNo());
			st.setString(12, wholesaleTransactionDetails.getStreet());
			st.setString(13, wholesaleTransactionDetails.getCity());
			st.setString(14, wholesaleTransactionDetails.getState());
			st.setString(15, wholesaleTransactionDetails.getCountry());
			st.setString(16, wholesaleTransactionDetails.getDate().toString());
			st.setString(17, wholesaleTransactionDetails.getPayment());
			st.setString(18, wholesaleTransactionDetails.getDelivery());
			st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	List<WholesaleTransactionDetails> selectByBuyerId(int buyerId){
		return selectAll("where buyerId='" +buyerId+ "'");
	}
	
	private List<WholesaleTransactionDetails> selectAll(String condition){
		List<WholesaleTransactionDetails> transaction = new ArrayList<WholesaleTransactionDetails>();
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from wholesaletransaction " +condition);
			
			while(rs.next()) {
				WholesaleTransactionDetails wholesaleTransactionDetails = 
						new WholesaleTransactionDetails(rs.getInt(1),
														rs.getInt(2),
														rs.getString(3),
														rs.getString(4),
														rs.getString(5),
														rs.getString(6),
														rs.getBigDecimal(7),
														rs.getInt(8), 
														rs.getString(9),
														rs.getInt(10),
														rs.getString(11),
														rs.getInt(12),
														rs.getString(13),
														rs.getString(14),
														rs.getString(15),
														rs.getString(16),
														LocalDateTime.parse(rs.getString(17)),
														rs.getString(18),
														rs.getString(19));
				
				transaction.add(wholesaleTransactionDetails);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transaction;
	}

	List<WholesaleTransactionDetails> selectBySellerId(int sellerId) {
		return selectAll("where sellerid='" +sellerId+ "'");
	}
	
	WholesaleTransactionDetails selectByWholesaleTransactionId(int id) {
		List<WholesaleTransactionDetails> transactions = selectAll("where id='" +id+ "'");
		
		if(transactions.isEmpty())
			return null;
		
		return transactions.get(0);
	}

	void setDeliveryStatus(String status, int id) {

		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			st.executeUpdate("update wholesaletransaction set delivery='" +status+ "' where id='"+id+"'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	List<WholesaleTransactionDetails> selectAll() {
		return selectAll("");
	}
}
