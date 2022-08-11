package bookshop.bookmanagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.Book;
import bookshop.bookmanagement.book.BookService;

/**
 * Servlet implementation class SearchMapping
 */
@SuppressWarnings("serial")
@WebServlet("/action-search")
public class SearchServlet extends HttpServlet {
	
	private BookService bookService = new BookService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter("search");
		long isbn = 0;
		
		try {
			isbn = Long.parseLong(search);
		}catch(Exception e) {}
		
		List<Book> booksByBookName = bookService.getBookByBookName(search);
		List<Book> booksByAuthor = bookService.getBookByAuthor(search);
		List<Book> booksByIsbn = bookService.getBookByIsbn(isbn);
		
		request.setAttribute("bybookname", booksByBookName);
		request.setAttribute("byauthor", booksByAuthor);
		request.setAttribute("byisbn", booksByIsbn);
		
		request.getRequestDispatcher("searchbook.jsp").forward(request, response);
	}

}
