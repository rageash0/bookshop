package bookshop.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import bookshop.credentials.appuser.address.Address;

public class TransactionDetails {
	
	private int id;
	private int bookId;
	private long isbn;
	private String bookName;
	private String author;
	private String edition;
	private String publisher;
	private BigDecimal price;
	private int sellerId;
	private String sellerName;
	private int buyerId;
	private String buyerName;
	private int houseNo;
	private String street;
	private String city;
	private String state;
	private String country;
	private LocalDateTime date;
	private String payment;
	private String delivery;

	public TransactionDetails(int id, 
								int bookId,
								long isbn,
								String bookName,
								String author,
								String edition,
								String publisher,
								BigDecimal price,
								int sellerId, 
								String sellerName,
								int buyerId,  
								String buyerName,
								int houseNo, 
								String street,
								String city,
								String state,
								String country,
								LocalDateTime date,
								String payment, 
								String delivery) {
		
		this(bookId, 
				isbn, 
				bookName, 
				author, 
				edition, 
				publisher, 
				price, 
				sellerId, 
				sellerName, 
				buyerId, 
				buyerName,
				houseNo,
				street,
				city,
				state,
				country,
				date,
				payment, 
				delivery);
		setId(id);
	}
	
	public TransactionDetails(int bookId,
								long isbn,
								String bookName,
								String author,
								String edition,
								String publisher,
								BigDecimal price,
								int sellerId,
								String sellerName,
								int buyerId, 
								String buyerName, 
								int houseNo,
								String street,
								String city,
								String state,
								String country,
								LocalDateTime date,
								String payment,
								String delivery) {

		setBookId(bookId);
		setIsbn(isbn);
		setBookName(bookName);
		setAuthor(author);
		setEdition(edition);
		setPublisher(publisher);
		setPrice(price);
		setSellerId(sellerId);
		setSellerName(sellerName);
		setBuyerId(buyerId);
		setBuyerName(buyerName);
		setHouseNo(houseNo);
		setStreet(street);
		setCity(city);
		setState(state);
		setCountry(country);
		setDate(date);
		setPayment(payment);
		setDelivery(delivery);
	}

	public int getId() {	return id;	}
	
	public int getSellerId() {	return sellerId;	}
	
	public int getBuyerId() {	return buyerId;		}
	
	public BigDecimal getPrice() {	return price;	}
	
	public LocalDateTime getDate() {		return date;	}
	
	
	private void setId(int id) {
		this.id = id;
	}
	
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
}
