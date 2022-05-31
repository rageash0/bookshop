package bookshop.requestbook;

public class RequestBook {
	
	private int id;
	private long isbn;
	private String bookName;
	private String author;
	private String edition;
	private String applicantName;
	
	public RequestBook(int id,
						long isbn,
						String bookName,
						String author,
						String edition,
						String applicantName) {
		
		this(isbn, bookName, author, edition, applicantName);
		setId(id);
	}
	
	public RequestBook(long isbn, 
						String bookName, 
						String author, 
						String edition, 
						String applicantName) {
		
		setIsbn(isbn);
		setBookName(bookName);
		setAuthor(author);
		setEdition(edition);
		setApplicantName(applicantName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
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

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
}
