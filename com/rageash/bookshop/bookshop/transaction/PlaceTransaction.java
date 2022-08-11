package bookshop.transaction;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import bookshop.bookmanagement.book.Book;
import bookshop.bookmanagement.book.BookService;
import bookshop.bookmanagement.book.addtocart.AddToCartService;
import bookshop.bookmanagement.book.wholesale.WholesaleService;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBook;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBookService;
import bookshop.credentials.appuser.AppUser;
import bookshop.credentials.appuser.AppUserService;
import bookshop.credentials.appuser.address.Address;
import bookshop.credentials.appuser.address.AddressService;

public class PlaceTransaction {
	
	private TransactionService transactionService = new TransactionService();
	private AppUserService appUserService = new AppUserService();
	private AddToCartService addToCartService = new AddToCartService();
	private BookService bookService = new BookService();
	private WholesaleService wholesaleService = new WholesaleService();

	public boolean updateWholesaleBookOrder(List<WholesaleBook> books, Address address, AppUser buyer, String payment) {

		int wholesaleId = books.get(0).getWholesaleId();
		String wholesaleName = wholesaleService.getById(wholesaleId).getName();
		String wholesaleDescription = wholesaleService.getById(wholesaleId).getDescription();
		String isbn = "";
		String bookName = "";
		BigDecimal price = wholesaleService.getById(wholesaleId).getPrice();
		int sellerId = wholesaleService.getById(wholesaleId).getSellerId();
		String sellerName = appUserService.getAppUser(sellerId).getFirstName();
		
		for(WholesaleBook book : books) {
			boolean success = transactionService.update(new WholesaleBookTransactionDetails(book.getBook().getBookId(),
																							book.getWholesaleId(),
																							book.getBook().getIsbn(),
																							book.getBook().getTitle(),
																							book.getBook().getAuthor(),
																							book.getBook().getPublisher(),
																							book.getBook().getEdition(),
																							book.getBook().getPrice()));
			
			if(!success)
				return false;
			
			isbn += book.getBook().getIsbn() + ", ";
			bookName += book.getBook().getTitle() + ", ";
		}
		
		WholesaleTransactionDetails wholesaleTransactionDetails = 
							new WholesaleTransactionDetails(wholesaleId,
															wholesaleName,
															wholesaleDescription,
															isbn,
															bookName,
															price,
															sellerId,
															sellerName,
															buyer.getId(),
															buyer.getFirstName(),
															address.getHouseNo(),
															address.getStreet(),
															address.getCity(),
															address.getState(),
															address.getCountry(),
															LocalDateTime.now(),
															payment,
															"Ordered");
		
		if(!transactionService.update(wholesaleTransactionDetails))
			return false;
		
		wholesaleService.remove(wholesaleId);
		
		return true;
	}
	
	public boolean updateBookOrder(List<Book> books, Address address, AppUser buyer, String payment) {
		for(Book book : books) {
			boolean success = transactionService.update(new TransactionDetails(book.getBookId(),
																book.getIsbn(),
																book.getTitle(),
																book.getAuthor(),
																book.getEdition(),
																book.getPublisher(),
																book.getPrice(),
																book.getSellerId(),
																appUserService.getAppUser(book.getSellerId()).getFirstName(),
																buyer.getId(),
																buyer.getFirstName(),
																address.getHouseNo(),
																address.getStreet(),
																address.getCity(),
																address.getState(),
																address.getCountry(),
																LocalDateTime.now(),
																payment,
																"Ordered"));
			
			if(!success)
				return false;

			addToCartService.removeFromCart(book.getBookId(), buyer.getId());
			bookService.removeBook(book.getBookId());
		}
		
		return true;
	}
}
