package bookshop.bookmanagement;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
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
import bookshop.bookmanagement.book.wholesale.WholesaleService;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBookService;
import bookshop.credentials.appuser.AppUserService;

@SuppressWarnings("serial")
@WebServlet("/BuyBooks")
public class BuyBooks extends HttpServlet {
	
	private AddToCartService addToCartService = new AddToCartService();
	private BookService bookService = new BookService();
	private AppUserService appUserService = new AppUserService();
	private WholesaleBookService wholesaleBookService = new WholesaleBookService();
	private WholesaleService wholesaleService = new WholesaleService();

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String username = (String) request.getSession().getAttribute("username");
		request.getSession().removeAttribute("wholesalelist");
		request.getSession().removeAttribute("buyingbooks");
		
		if(username == null) {
			response.sendRedirect("/bookshop/Login");
			return;
		}
		
		String wholesaleId = request.getParameter("wid");
		if(wholesaleId != null) {
			int wid = Integer.parseInt(wholesaleId);
			request.getSession().setAttribute("wholesalelist", wholesaleBookService.getByWholesaleId(wid));
			request.setAttribute("total", wholesaleService.getById(wid).getPrice());
			request.setAttribute("wholesalename", wholesaleService.getById(wid).getName());
			request.setAttribute("wholesaledescription", wholesaleService.getById(wid).getDescription());
			request.getRequestDispatcher("buybooks.jsp").forward(request, response);
			return;
		}
		
		String bookId = request.getParameter("bookid");
		List<AddToCart> booksInCart = addToCartService.getBooksFromBuyer(appUserService
																.getAppUser(username)
																.getId());
		
		List<Integer> bookIds = booksInCart.stream().map(AddToCart::getBookId).toList();
		List<Book> books = bookService.getBooks(bookIds);
		double sum = 0;
		
		if(bookId != null) {
			List<Book> singleBook = Arrays.asList(bookService.getBook(Integer.parseInt(bookId)));
			
			request.getSession().setAttribute("buyingbooks", singleBook);
			sum += singleBook.get(0).getPrice().doubleValue();
		}else if(books.size() <= 0 ){
			response.sendRedirect("/bookshop/Profile");
			return;
		}else {

			request.getSession().setAttribute("buyingbooks", books);

			for(Book b : books)
				sum += b.getPrice().doubleValue();
		}
		
		
		request.setAttribute("total", sum);
		request.getRequestDispatcher("buybooks.jsp").forward(request, response);
	}
}
