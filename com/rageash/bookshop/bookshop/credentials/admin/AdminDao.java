package bookshop.credentials.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bookshop.databaseconnection.DataAccessObject;

public class AdminDao{
	
	private DataAccessObject database = new DataAccessObject();
	
	Admin selectByAdminName(String adminName) {
		return selectAll("where adminname = '" +adminName+ "'");
	}
	
	Admin selectByCredential(String adminName, String password) {
		return selectAll("where adminname='" +adminName+ "' and password='" +password+ "'");
	}
	
	private Admin selectAll(String condition) {
		Admin admin = null;
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select firstname, lastname, adminname from admin "
												+condition);
			
			if(rs.next())
				admin = new Admin(rs.getString(1),		//first name
									rs.getString(2),	//last name
									rs.getString(3));	//admin name
			
			con.close();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return admin;
	}
	
	boolean add(AuthenticatedAdmin admin) {
		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into admin "
									+ "values(?, ?, ?, ?)");
			
			st.setString(1, admin.getFirstName());
			st.setString(2, admin.getLastName());
			st.setString(3, admin.getAdminName());
			st.setString(4, admin.getPassword());
			
			st.executeQuery();
			st.close(); 
			con.close();
			
			return true;
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}