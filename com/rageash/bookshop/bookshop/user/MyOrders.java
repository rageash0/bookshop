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
import bookshop.credentials.appuser.AppUserService;
import bookshop.transaction.TransactionDetails;
import bookshop.transaction.TransactionService;

@SuppressWarnings("serial")
@WebServlet("/MyOrders")
public class MyOrders extends HttpServlet{
	
	private BookService bookService = new BookService();
	private TransactionService transactionService = new TransactionService();
	private AppUserService appUserService = new AppUserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		String username = (String) request.getSession().getAttribute("username");
		
		if(username == null)
			response.sendRedirect("/bookshop/Welcome");
		else {
			
			List<Integer> bookId = transactionService.getByBuyerId(appUserService
																	.getAppUser(username)
																	.getId())
																		.stream()
																		.map(TransactionDetails::getBookId)
																		.toList();
			
			List<Book> books = bookService.getBooks(bookId);
			
			request.setAttribute("books", books);
			request.getRequestDispatcher("myorders.jsp").forward(request, response);
		}
	}
}
