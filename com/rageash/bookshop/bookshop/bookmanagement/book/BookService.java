package bookshop.bookmanagement.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookService {

	private BookDao bookDao = new BookDao();
	
	public boolean add(Book book) {
		return bookDao.addRecord(book);
	}
	
	public Book getBook(int id) {
		return bookDao.selectById(id);
	}

	public List<Book> getAllBooks(){
		return bookDao.selectAll();
	}
	
	public List<Book> myBooks(int sellerId) {
		return bookDao.selectBySellerId(sellerId);
	}
	
	public List<Book> getBooksExceptFrom(int sellerId){
		return bookDao.selectAllButNot(sellerId);
	}

	public List<Book> getBooks(List<Integer> bookIdList) {
		List<Book> bookList = new ArrayList<Book>();
		
		for(Iterator<Integer> iterator = bookIdList.iterator(); iterator.hasNext();)
			bookList.add(getBook((int) iterator.next()));
		
		return bookList;
	}

	public List<Book> getBooksByCategory(String category) {
		// TODO Auto-generated method stub
		return bookDao.selectBooksByCategory(category);
	}

	public List<Book> getBookByLastPosted() {
		return bookDao.selectBooksByLastPosted();
	}
	
	public List<Book> getBookByBookName(String bookName){
		return bookDao.selectAllFromBookName(bookName);
	}
	
	public List<Book> getBookByAuthor(String author){
		return bookDao.selectAllFromAuthor(author);
	}
	
	public List<Book> getBookByIsbn(long isbn){
		return bookDao.selectAllFromIsbn(isbn);
	}
	
	public boolean removeBook(int bookId) {
		return bookDao.removeRecord(bookId);
	}
}
