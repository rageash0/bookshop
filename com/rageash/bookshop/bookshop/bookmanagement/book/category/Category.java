package bookshop.bookmanagement.book.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import bookshop.databaseconnection.DataAccessObject;

public class Category {
	private DataAccessObject database = new DataAccessObject();
	
	public List<String> getList(){
		List<String> categories = new ArrayList<String>();
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from category");
			
			while(rs.next())
				categories.add(rs.getString(1));
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categories;
	}
	
	boolean add(String category) {
		
		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into category values(?)");
			
			st.setString(1, category);
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
}
