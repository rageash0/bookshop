package bookshop.bookmanagement.book.wholesale;

import java.math.BigDecimal;

public class Wholesale {

	private int id;
	private String name;
	private String description;
	private int noOfBooks;
	private BigDecimal price;
	private int sellerId;
	
	@SuppressWarnings("deprecation")
	public Wholesale(String name, 
						String description, 
						int noOfBooks, 
						BigDecimal price, 
						int sellerId) {
		setName(name);
		setDescription(description);
		setNoOfBooks(noOfBooks);
		setPrice(price.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		setSellerId(sellerId);
	}
	
	public Wholesale(int id, 
						String name, 
						String description,
						int noOfBooks,
						BigDecimal price,
						int sellerId) {
		this(name, description, noOfBooks, price, sellerId);
		setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
