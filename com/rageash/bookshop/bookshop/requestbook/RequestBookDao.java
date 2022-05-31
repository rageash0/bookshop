package bookshop.requestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.databaseconnection.DataAccessObject;

public class RequestBookDao {

	private DataAccessObject database = new DataAccessObject();
	
	boolean addRecord(RequestBook requestBook) {
		
		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into requestform(isbn, "
																				+ "bookname, "
																				+ "author, "
																				+ "edition, "
																				+ "applicantname) values(?, ?, ?, ?, ?)");
			st.setLong(1, requestBook.getIsbn());
			st.setString(2, requestBook.getBookName());
			st.setString(3, requestBook.getAuthor());
			st.setString(4, requestBook.getEdition());
			st.setString(5, requestBook.getApplicantName());
			
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
	
	List<RequestBook> selectAll(){
		return selectAll("");
	}
	
	private List<RequestBook> selectAll(String condition){
		List<RequestBook> requestList = new ArrayList<RequestBook>();
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from requestform " +condition);
			
			while(rs.next()) {
				RequestBook requestBook = new RequestBook(rs.getInt(1),
															rs.getLong(2),
															rs.getString(3),
															rs.getString(4),
															rs.getString(5),
															rs.getString(6));
				
				requestList.add(requestBook);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return requestList;
	}
}
