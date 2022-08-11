package bookshop.credentials.appuser;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.databaseconnection.DataAccessObject;

public class AppUserDao{
	
	private DataAccessObject database = new DataAccessObject();
	
	AppUser selectById(int id) {
		return selectAll("where id='" +id+ "'").get(0);
	}

	AppUser selectByUsername(String username) {
		return selectAll("where username='" +username+ "'").get(0);
	}
	
	AppUser selectByCredential(String username, String password) {
		List<AppUser> users = selectAll("where username='" +username+ "' and password='" +password+ "'");
		
		if(users.isEmpty())
			return null;
		
		return users.get(0);
	}
	
	List<AppUser> selectAll(){
		return selectAll("");
	}
	
	boolean addRecord(AuthenticatedAppUser user) {
		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into user(firstname, "
																		+ "lastname, "
																		+ "dob, "
																		+ "username, "
																		+ "password, "
																		+ "email, "
																		+ "mobilenumber)"
																		+ " values(?, ?, ?, ?, ?, ?, ?)");
			
			st.setString(1, user.getFirstName());
			st.setString(2, user.getLastName());
			st.setDate(3, (Date) user.getDob());
			st.setString(4, user.getUsername());
			st.setString(5, user.getPassword());
			st.setString(6, user.getEmail());
			st.setString(7, user.getMobileNumber());
			
			st.executeUpdate();
			st.close();
			con.close();
			
			return true;
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private List<AppUser> selectAll(String condition){
		List<AppUser> userList = new ArrayList<AppUser>();
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select id, firstname, lastname, dob, username, "
										+ "email, mobilenumber from user " +condition);
			
			while(rs.next()) {
				AppUser user = new AppUser(rs.getInt(1),
											rs.getString(2),
											rs.getString(3),
											rs.getDate(4),
											rs.getString(5),
											rs.getString(6),
											rs.getString(7));
				
				userList.add(user);
			}
			
			con.close();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	private void update(int id, String query) {
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			st.execute("update user set " +query+ " where id='" +id+ "'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void updateFirstName(int id, String firstName) {
		update(id, "firstname='" +firstName+ "'");
	}
	
	void updateLastName(int id, String lastName) {
		update(id, "lastname='" +lastName+ "'");
	}
	
	void updateDob(int id, Date dob) {
		update(id, "dob='" +dob+ "'");
	}
	
	void updateEmail(int id, String email) {
		update(id, "email='" +email+ "'");
	}
	
	void updateMobileNumber(int id, String mobileNumber) {
		update(id, "mobilenumber='" +mobileNumber+ "'");
	}
	
	void updatePassword(int id, String password) {
		update(id, "password='" +password+ "'");
	}
	
	boolean delete(int id) {
		try {
			database.openConnection()
					.createStatement()
					.executeUpdate("delete from user where id='" +id+ "'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
