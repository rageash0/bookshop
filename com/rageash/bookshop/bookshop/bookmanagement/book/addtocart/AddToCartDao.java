package bookshop.bookmanagement.book.addtocart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.databaseconnection.DataAccessObject;

public class AddToCartDao {

	private DataAccessObject database = new DataAccessObject();
	
	boolean isAddedToCart(int bookId, int buyerId) {
		return selectAll("where bookid='" +bookId+ "' and buyerid='" +buyerId+ "'").size() > 0;
	}
	
	boolean addToCart(int bookId, int buyerId) {
		
		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into cart(bookid, buyerid) values(?, ?)");
			
			st.setInt(1, bookId);
			st.setInt(2, buyerId);
			
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
	
	boolean removeFromCart(int bookId, int buyerId) {
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			st.executeUpdate("delete from cart where bookid='" +bookId+ "' and buyerid='" +buyerId+ "'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	List<AddToCart> selectAll(){
		return selectAll("");
	}
	
	List<AddToCart> selectAllFrom(int buyerId){
		return selectAll("where buyerid='" +buyerId+ "'");
	}
	
	private List<AddToCart> selectAll(String condition){
		List<AddToCart> addToCart = new ArrayList<AddToCart>();
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from cart " +condition);
			
			while(rs.next())
				addToCart.add(new AddToCart(rs.getInt(1),
											rs.getInt(2),
											rs.getInt(3)));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addToCart;
	}
}
