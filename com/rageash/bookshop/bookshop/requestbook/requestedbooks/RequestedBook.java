package bookshop.requestbook.requestedbooks;

import bookshop.requestbook.RequestBook;

public class RequestedBook {

	private RequestBook requestBook;
	private int count;
	
	public RequestedBook(RequestBook requestBook, int count) {
		setRequestBook(requestBook);
		setCount(count);
	}

	public RequestBook getRequestBook() {
		return requestBook;
	}

	public void setRequestBook(RequestBook requestBook) {
		this.requestBook = requestBook;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void increaseCount() {
		count++;
	}
}
