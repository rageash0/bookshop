package bookshop.transaction;

import java.math.BigDecimal;

public class WholesaleBookTransactionDetails {

	private int id;
	private int bookId;
	private int wholesaleId;
	private Long isbn;
	private String bookName;
	private String author;
	private String publisher;
	private String edition;
	private BigDecimal price;
	
	public WholesaleBookTransactionDetails(int bookId,
											int wholesaleId,
											Long isbn,
											String bookName,
											String author,
											String publisher,
											String edition,
											BigDecimal price) {
		
		setBookId(bookId);
		setWholesaleId(wholesaleId);
		setIsbn(isbn);
		setBookName(bookName);
		setAuthor(author);
		setPublisher(publisher);
		setEdition(edition);
		setPrice(price);
	}
	
	public WholesaleBookTransactionDetails(int id,
											int bookId,
											int wholesaleId,
											Long isbn,
											String bookName,
											String author,
											String publisher,
											String edition,
											BigDecimal price) {
		
		this(bookId, wholesaleId, isbn, bookName, author, publisher, edition, price);
		setId(id);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getWholesaleId() {
		return wholesaleId;
	}
	public void setWholesaleId(int wholesaleId) {
		this.wholesaleId = wholesaleId;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
