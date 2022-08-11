package bookshop.bookmanagement.book.wholesale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.databaseconnection.DataAccessObject;

public class WholesaleDao {

	private DataAccessObject database = new DataAccessObject();
	
	boolean addRecord(Wholesale wholesale) {

		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into wholesale(name, "
																			+ "description, "
																			+ "noofbooks, "
																			+ "price, "
																			+ "sellerid) "
																			+ "values(?, ?, ?, ?, ?)");
			
			st.setString(1, wholesale.getName());
			st.setString(2, wholesale.getDescription());
			st.setInt(3, wholesale.getNoOfBooks());
			st.setBigDecimal(4, wholesale.getPrice());
			st.setInt(5, wholesale.getSellerId());
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
	
	List<Wholesale> selectBySellerId(int id) {
		return selectAll("where sellerid='" +id+ "'");
	}
	
	Wholesale selectByName(String name){
		List<Wholesale> wholesale = selectAll("where name='" +name+ "'");
		
		if(wholesale.isEmpty())
			return null;
		
		return wholesale.get(0);
	}
	
	Wholesale selectById(int id){
		List<Wholesale> wholesale = selectAll("where id='" +id+ "'");
		
		if(wholesale.isEmpty())
			return null;
		
		return wholesale.get(0);
	}
	
	List<Wholesale> selectAll(){
		return selectAll("");
	}
	
	private List<Wholesale> selectAll(String condition){
		List<Wholesale> wholesale = new ArrayList<Wholesale>();
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from wholesale " +condition);
			
			while(rs.next())
				wholesale.add(new Wholesale(rs.getInt(1), 
											rs.getString(2), 
											rs.getString(3),
											rs.getInt(4),
											rs.getBigDecimal(5),
											rs.getInt(6)));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wholesale;
	}
	
	boolean removeRecord(int wholesaleId) {
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			st.executeUpdate("delete from wholesale where id='" +wholesaleId+ "'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
