package bookshop.bookmanagement.book.wholesale.wholesalebook;

import bookshop.bookmanagement.book.Book;

public class WholesaleBook {

	private Book book;
	private int wholesaleId;
	
	public WholesaleBook(Book book) {
		setBook(book);
	}
	
	public WholesaleBook(Book book, int wholesaleId){
		this(book);
		setWholesaleId(wholesaleId);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getWholesaleId() {
		return wholesaleId;
	}

	public void setWholesaleId(int wholesaleId) {
		this.wholesaleId = wholesaleId;
	}
}
