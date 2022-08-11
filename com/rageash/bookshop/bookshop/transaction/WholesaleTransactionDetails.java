package bookshop.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WholesaleTransactionDetails {

	private int id;
	private int wholesaleId;
	private String wholesaleName;
	private String wholesaleDescription;
	private String isbn;
	private String bookName;
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
	
	public WholesaleTransactionDetails(int wholesaleId,
										String wholesaleName,
										String wholesaleDescription,
										String isbn,
										String bookName,
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
		
		setWholesaleId(wholesaleId);
		setWholesaleName(wholesaleName);
		setWholesaleDescription(wholesaleDescription);
		setIsbn(isbn);
		setBookName(bookName);
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
	
	public WholesaleTransactionDetails(int id, 
										int wholesaleId,
										String wholesaleName,
										String wholesaleDescription,
										String isbn,
										String bookName,
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
		this(wholesaleId, 
				wholesaleName, 
				wholesaleDescription, 
				isbn, 
				bookName, 
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWholesaleId() {
		return wholesaleId;
	}
	public void setWholesaleId(int wholesaleId) {
		this.wholesaleId = wholesaleId;
	}
	public String getWholesaleName() {
		return wholesaleName;
	}
	public void setWholesaleName(String wholesaleName) {
		this.wholesaleName = wholesaleName;
	}
	public String getWholesaleDescription() {
		return wholesaleDescription;
	}
	public void setWholesaleDescription(String wholesaleDescription) {
		this.wholesaleDescription = wholesaleDescription;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
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
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	
	
}
