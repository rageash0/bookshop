package bookshop.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.Book;
import bookshop.bookmanagement.book.BookService;
import bookshop.bookmanagement.book.addtocart.AddToCart;
import bookshop.bookmanagement.book.addtocart.AddToCartService;
import bookshop.bookmanagement.book.wholesale.Wholesale;
import bookshop.bookmanagement.book.wholesale.WholesaleService;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBookService;
import bookshop.credentials.appuser.AppUser;
import bookshop.credentials.appuser.AppUserService;
import bookshop.transaction.TransactionDetails;
import bookshop.transaction.TransactionService;
import bookshop.transaction.WholesaleTransactionDetails;

@SuppressWarnings("serial")
@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet{
	
	private AppUserService appUserService = new AppUserService();
	private BookService bookService = new BookService();
	private AddToCartService addToCartService = new AddToCartService();
	private TransactionService transactionService = new TransactionService();
	private WholesaleService wholesaleService = new WholesaleService();
	private WholesaleBookService wholesaleBookService = new WholesaleBookService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		String username = (String) request.getSession().getAttribute("username");
		int id = appUserService.getAppUser(username).getId();
		String view = request.getParameter("view");
		
		if(username == null) {
			response.sendRedirect("/bookshop/Index");
			return;
		}
		
		if(view == null);
		else if(view.compareTo("cart") == 0) {
			List<Integer> bookIds = addToCartService.getBooksFromBuyer(id)
													.stream()
													.map(AddToCart::getBookId)
													.toList();
			
			List<Book> books = bookService.getBooks(bookIds);
			request.setAttribute("books", books);
			
		}else if(view.compareTo("orders") == 0) {
			List<TransactionDetails> transactionDetails = transactionService.getByBuyerId(id);
			request.setAttribute("orders", transactionDetails);
			List<WholesaleTransactionDetails> wholesaleTransactionDetails = transactionService.getWholesaleByBuyerId(id);
			request.setAttribute("wholesaleorders", wholesaleTransactionDetails);
		}else if(view.compareTo("buyers") == 0) {
			List<TransactionDetails> transactionDetails = transactionService.getBySellerId(id);
			request.setAttribute("buyers", transactionDetails);
			List<WholesaleTransactionDetails> wholesaleTransactionDetails = transactionService.getWholesaleBySellerId(id);
			request.setAttribute("wholesalebuyers", wholesaleTransactionDetails);
		}else if(view.compareTo("wholesale") == 0) {
			List<Wholesale> wholesaleList = wholesaleService.getBySellerId(id);
			request.setAttribute("wholesalelist", wholesaleList);
		}
		
		AppUser user = appUserService.getAppUser(username);
		
		request.setAttribute("firstname", user.getFirstName());
		request.setAttribute("lastname", user.getLastName());
		request.setAttribute("dob", user.getDob());
		request.setAttribute("username", user.getUsername());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("mobilenumber", user.getMobileNumber());
		request.setAttribute("mybook", bookService.myBooks(appUserService
															.getAppUser(username)
															.getId()));
		
		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}
}
