package bookshop.bookmanagement.book;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.databaseconnection.DataAccessObject;

public class BookDao{
	
	private DataAccessObject database = new DataAccessObject();

	boolean addRecord(Book book) {

		try {
			Connection con = database.openConnection();
			PreparedStatement st = con.prepareStatement("insert into book(isbn, "
																	+ "bookname, "
																	+ "author, "
																	+ "publisher, "
																	+ "edition, "
																	+ "pages, "
																	+ "price, "
																	+ "cover, "
																	+ "description, "
																	+ "sellerid,"
																	+ "category,"
																	+ "language)"
																	+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			st.setLong(1, book.getIsbn());
			st.setString(2, book.getTitle());
			st.setString(3, book.getAuthor());
			st.setString(4, book.getPublisher());
			st.setString(5, book.getEdition());
			st.setInt(6, book.getPages());
			st.setBigDecimal(7, book.getPrice());
			st.setBlob(8,  book.getImage());
			st.setString(9, book.getDescription());
			st.setInt(10, book.getSellerId());
			st.setString(11, book.getCategory());
			st.setString(12, book.getLanguage());
			
			st.executeUpdate();
			st.close();
			con.close();
			
			return true;
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	boolean removeRecord(int bookId) {
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			st.executeUpdate("delete from book where bookid='" +bookId+ "'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	Book selectById(int id) {
		return selectAll("where bookid='" +id+ "'").get(0);
	}

	List<Book> selectBySellerId(int sellerId){
		return selectAll("where sellerid='" +sellerId+ "'");
	}
	
	List<Book> selectAllButNot(int sellerId){
		return selectAll("where sellerid!='"+sellerId+ "'");
	}
	
	List<Book> selectAll(){
		return selectAll("");
	}
	
	List<Book> selectAllFromBookName(String bookName){
		return selectAll("where bookname ='" +bookName+ "'");
	}
	
	List<Book> selectAllFromAuthor(String author){
		return selectAll("where author='" +author+ "'");
	}
	
	List<Book> selectAllFromIsbn(long isbn){
		return selectAll("where isbn='" +isbn+ "'");
	}
	
	private List<Book> selectAll(String condition){
		List<Book> books = new ArrayList<Book>();
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book " +condition);
			
			while(rs.next()) {
				Book book = new Book(rs.getInt(1),		//Book ID
						rs.getLong(2),					//ISBN
						rs.getString(3),				//Title
						rs.getString(4),				//Author
						rs.getString(5),				//Publisher
						rs.getString(6),				//Edition
						rs.getInt(7),					//Page
						rs.getBigDecimal(8),			//Price
						rs.getBlob(9),					//Cover image
						rs.getString(10),				//Description
						rs.getInt(11),					//Seller Id
						rs.getString(12),				//Category
						rs.getString(13));				//Language
				
				books.add(book);
			}
			
			con.close();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return books;
		
	}

	List<Book> selectBooksByCategory(String category) {
		return selectAll("where category ='" +category+ "'");
	}
	
	List<Book> selectBooksByLastPosted(){
		return selectAll("order by bookid DESC");
	}

	private void update(int id, String attributeName, String attributeValue) {
		
		try {
			Connection con = database.openConnection();
			Statement st = con.createStatement();
			st.execute("update book set " +attributeName+ "='" +attributeValue+ "' where id='" +id+ "'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void updateIsbn(int id, long isbn) {
		update(id, "isbn", isbn+"");
	}
	
	void updateBookName(int id, String bookName) {
		update(id, "bookName", bookName);
	}
	
	void updateAuthor(int id, String author) {
		update(id, "author", author);
	}
	
	void updatePublisher(int id, String publisher) {
		update(id, "publisher", publisher);
	}
	
	void updateEdition(int id, String edition) {
		update(id, "edition", edition);
	}
	
	void updatePages(int id, int pages) {
		update(id, "pages", pages+"");
	}
	
	void updatePrice(int id, BigDecimal price) {
		update(id, "price", price+"");
	}
	
	void updateDescription(int id, String description) {
		update(id, "description", description);
	}
}
