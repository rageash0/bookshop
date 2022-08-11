package bookshop.bookmanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.Book;
import bookshop.bookmanagement.book.BookService;
import bookshop.bookmanagement.book.addtocart.AddToCartService;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBook;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBookService;
import bookshop.credentials.appuser.AppUserService;

@SuppressWarnings("serial")
@WebServlet("/Viewbook")
public class ViewBookMapping extends HttpServlet{

	private BookService bookService = new BookService();
	private AppUserService appUserService = new AppUserService();
	private AddToCartService addToCartService = new AddToCartService();
	private WholesaleBookService wholesaleBookService = new WholesaleBookService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String username = (String) request.getSession().getAttribute("username");
		
		String bookId = request.getParameter("id");
		String wholesaleBookId = request.getParameter("wid");
		
		int id = -1;
		if(username != null)
			id = appUserService.getAppUser(username).getId();
		
		Book book = null;
		
		if(bookId != null) {
			book = bookService.getBook(Integer.parseInt(bookId));
			boolean carted = addToCartService.isAddedToCart(Integer.parseInt(bookId), id);
			request.setAttribute("addedtocart", carted);
		}else if(wholesaleBookId != null) {
			book = wholesaleBookService.getByBookId(Integer.parseInt(wholesaleBookId)).getBook();
			request.setAttribute("iswholesale", true);
		}	
		else {
			response.sendRedirect("/bookshop/Index");
			return;
		}

		request.setAttribute("book", book);
		request.setAttribute("userid", id);
		request.getRequestDispatcher("viewbook.jsp").forward(request, response);
	}
}
