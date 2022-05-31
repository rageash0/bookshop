package bookshop.bookmanagement.book.addtocart;

public class AddToCart {

	private int cartId;
	private int bookId;
	private int buyerId;
	
	public AddToCart(int bookId, int buyerId) {
		setBookId(bookId);
		setBuyerId(buyerId);
	}
	
	public AddToCart(int cartId, int bookId, int buyerId) {
		this(bookId, buyerId);
		this.setCartId(cartId);
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
}
