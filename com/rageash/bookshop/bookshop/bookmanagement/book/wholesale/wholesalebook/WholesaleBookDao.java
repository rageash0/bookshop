package bookshop.bookmanagement.book.wholesale.wholesalebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.bookmanagement.book.Book;
import bookshop.databaseconnection.DataAccessObject;

public class WholesaleBookDao {

	private DataAccessObject database = new DataAccessObject();
	
	boolean addRecord(List<WholesaleBook> wholesaleBooks, int wholesaleId) {
		
		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into wholesalebook(isbn, "
																				+ "bookname, "
																				+ "author, "
																				+ "publisher, "
																				+ "edition, "
																				+ "pages, "
																				+ "price, "
																				+ "cover, "
																				+ "description, "
																				+ "sellerid, "
																				+ "category, "
																				+ "language, "
																				+ "wholesaleid) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			for(WholesaleBook wholesaleBook : wholesaleBooks) {
				st.setLong(1, wholesaleBook.getBook().getIsbn());
				st.setString(2, wholesaleBook.getBook().getTitle());
				st.setString(3, wholesaleBook.getBook().getAuthor());
				st.setString(4, wholesaleBook.getBook().getPublisher());
				st.setString(5, wholesaleBook.getBook().getEdition());
				st.setInt(6, wholesaleBook.getBook().getPages());
				st.setBigDecimal(7, wholesaleBook.getBook().getPrice());
				st.setBlob(8, wholesaleBook.getBook().getImage());
				st.setString(9, wholesaleBook.getBook().getDescription());
				st.setInt(10, wholesaleBook.getBook().getSellerId());
				st.setString(11, wholesaleBook.getBook().getCategory());
				st.setString(12, wholesaleBook.getBook().getLanguage());
				st.setInt(13, wholesaleId);
				
				st.executeUpdate();
			}
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	List<WholesaleBook> selectByWholesaleId(int id){
		return selectAll("where wholesaleid='" +id+ "'");
	}
	
	WholesaleBook selectByBookId(int id){
		List<WholesaleBook> wholesaleBook = selectAll("where bookid='" +id+ "'");
		
		if(wholesaleBook.isEmpty())
			return null;
		
		return wholesaleBook.get(0);
	}
	
	List<WholesaleBook> selectAll(){
		return selectAll("");
	}
	
	private List<WholesaleBook> selectAll(String condition){
		List<WholesaleBook> wholesaleBooks = new ArrayList<WholesaleBook>();
		
		try {
			Connection connection = database.openConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from wholesalebook " +condition);
			
			while(rs.next()) {
				WholesaleBook wholesaleBook = new WholesaleBook(new Book(rs.getInt(1),				//Book ID
																			rs.getLong(2),			//ISBN
																			rs.getString(3),		//Title
																			rs.getString(4),		//Author
																			rs.getString(5),		//Publisher
																			rs.getString(6),		//Edition
																			rs.getInt(7),			//Page
																			rs.getBigDecimal(8),	//Price
																			rs.getBlob(9),			//Cover image
																			rs.getString(10),		//Description
																			rs.getInt(11),			//Seller Id
																			rs.getString(12),		//Category
																			rs.getString(13)),		//Language		
																			rs.getInt(14));			//Wholesale Id
				
				wholesaleBooks.add(wholesaleBook);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wholesaleBooks;
	}

	boolean removeByWholesaleId(int wholesaleId) {

		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			st.executeUpdate("delete from wholesalebook where wholesaleid='" +wholesaleId+ "'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
