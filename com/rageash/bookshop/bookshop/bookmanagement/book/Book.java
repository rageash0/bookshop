package bookshop.bookmanagement.book;

import java.math.BigDecimal;
import java.sql.Blob;

public class Book {
	
	private int bookId;
	private long isbn;
	private String title;
	private String author;
	private String publisher;
	private String edition;
	private int pages;
	private BigDecimal price;
	private Blob image;
	private String description;
	private int sellerId;
	private String category;
	private String language;
	
	@SuppressWarnings("deprecation")
	public Book(long isbn,
				String title, 
				String author, 
				String publisher,
				String edition,
				int pages, 
				BigDecimal price, 
				Blob image, 
				String description,
				int sellerId,
				String category,
				String language) {

		setIsbn(isbn);
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setEdition(edition);
		setPages(pages);
		setPrice(price.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		setImage(image);
		setDescription(description);
		setSellerId(sellerId);
		setCategory(category);
		setLanguage(language);
	}

	public Book(int bookId, 
				long isbn,
				String title, 
				String author, 
				String publisher,
				String edition,
				int pages, 
				BigDecimal price, 
				Blob image, 
				String description,
				int sellerId,
				String category,
				String language) {

		this(isbn, title, author, publisher, edition, pages, price, image, description, sellerId, category, language);
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBookId() {
		return bookId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
