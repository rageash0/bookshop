package bookshop.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.databaseconnection.DataAccessObject;

public class WholesaleBookTransactionDao {

	private DataAccessObject database = new DataAccessObject();
	
	boolean addRecord(WholesaleBookTransactionDetails wholesaleBookTransactionDetails) {
		
		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into wholesalebooktransaction(bookid, "
																							+ "wholesaleid, "
																							+ "isbn, "
																							+ "bookname, "
																							+ "author, "
																							+ "publisher, "
																							+ "edition, "
																							+ "price) values(?, ? ,? ,? ,?, ?, ?, ?)");
			
			st.setInt(1, wholesaleBookTransactionDetails.getBookId());
			st.setInt(2, wholesaleBookTransactionDetails.getWholesaleId());
			st.setLong(3, wholesaleBookTransactionDetails.getIsbn());
			st.setString(4, wholesaleBookTransactionDetails.getBookName());
			st.setString(5, wholesaleBookTransactionDetails.getAuthor());
			st.setString(6, wholesaleBookTransactionDetails.getPublisher());
			st.setString(7, wholesaleBookTransactionDetails.getEdition());
			st.setBigDecimal(8, wholesaleBookTransactionDetails.getPrice());
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
	
	private List<WholesaleBookTransactionDetails> selectAll(String condition){
		List<WholesaleBookTransactionDetails> transaction = new ArrayList<WholesaleBookTransactionDetails>();
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from wholesalebooktransaction " +condition);
			
			while(rs.next()) {
				WholesaleBookTransactionDetails wholesaleBookTransactionDetails = 
						new WholesaleBookTransactionDetails(rs.getInt(1),
															rs.getInt(2),
															rs.getInt(3),
															rs.getLong(4),
															rs.getString(5),
															rs.getString(6),
															rs.getString(7),
															rs.getString(8),
															rs.getBigDecimal(9));
				
				transaction.add(wholesaleBookTransactionDetails);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transaction;
	}
}