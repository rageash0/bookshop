package bookshop.credentials.appuser.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.databaseconnection.DataAccessObject;

public class AddressDao {

	private DataAccessObject database = new DataAccessObject();
	
	boolean addRecord(Address address) {
		
		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into address(userid, "
																			+ "houseno, "
																			+ "street, "
																			+ "city, "
																			+ "state, "
																			+ "country) values(?, ?, ?, ?, ?, ?)");
			
			st.setInt(1, address.getUserId());
			st.setInt(2, address.getHouseNo());
			st.setString(3, address.getStreet());
			st.setString(4, address.getCity());
			st.setString(5, address.getState());
			st.setString(6, address.getCountry());
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
	
	List<Address> selectByUserId(int userId){
		return selectAll("where userid='" +userId+ "'");
	}
	
	Address selectById(int id) {
		List<Address> address = selectAll("where id='" +id+ "'");
		
		if(address.isEmpty())
			return null;
		
		return address.get(0);
	}
	
	List<Address> selectAll(){
		return selectAll("");
	}
	
	private List<Address> selectAll(String condition){
		List<Address> addressList = new ArrayList<Address>();
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from address " +condition);
			
			while(rs.next())
				addressList.add(new Address(rs.getInt(1),
											rs.getInt(2),
											rs.getInt(3),
											rs.getString(4),
											rs.getString(5),
											rs.getString(6),
											rs.getString(7)));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addressList;
	}
}
