package bookshop.bookmanagement.book.language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.databaseconnection.DataAccessObject;

public class Language {
	
	private DataAccessObject database = new DataAccessObject();
	
	public List<String> getList(){
		List<String> languages = new ArrayList<String>();
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from language");
			
			while(rs.next())
				languages.add(rs.getString(1));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return languages;
	}
	
	boolean add(String language) {
		
		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into language values(?)");
			
			st.setString(1, language);
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
