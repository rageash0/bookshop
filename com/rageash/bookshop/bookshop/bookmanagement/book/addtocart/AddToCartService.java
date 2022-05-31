package bookshop.bookmanagement.book.addtocart;

import java.util.List;

public class AddToCartService {
	private AddToCartDao addToCartDao = new AddToCartDao();
	
	public boolean isAddedToCart(int bookId, int buyerId) {
		return addToCartDao.isAddedToCart(bookId, buyerId);
	}
	
	public boolean addToCart(int bookId, int buyerId) {
		return addToCartDao.addToCart(bookId, buyerId);
	}
	
	public boolean removeFromCart(int bookId, int buyerId) {
		return addToCartDao.removeFromCart(bookId, buyerId);
	}
	
	public List<AddToCart> getAllBooks(){
		return addToCartDao.selectAll();
	}
	
	public List<AddToCart> getBooksFromBuyer(int buyerId){
		return addToCartDao.selectAllFrom(buyerId);
	}
}
