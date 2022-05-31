package bookshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.Book;
import bookshop.bookmanagement.book.BookService;
import bookshop.bookmanagement.book.category.Category;

@SuppressWarnings("serial")
@WebServlet("/Index")
public class IndexMapping extends HttpServlet{
	
	private BookService bookService = new BookService();
	private Category category = new Category();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		String adminName = (String) request.getSession().getAttribute("adminname");
		
		List<Book> fiction = bookService.getBooksByCategory("Fiction");
		List<Book> mythology = bookService.getBooksByCategory("Mythology");
		List<Book> textBook = bookService.getBooksByCategory("Textbook");
		List<Book> newList = bookService.getBookByLastPosted();
		
		if(fiction.size() > 5) 		fiction = fiction.subList(0, 5);
		if(mythology.size() > 5)	mythology = mythology.subList(0, 5);
		if(textBook.size() > 5)		textBook = textBook.subList(0, 5);
		if(newList.size() > 5)		newList = newList.subList(0, 5);
			
		
		if(adminName != null)
			response.sendRedirect("/bookshop/Adminhome");
		else {
			request.setAttribute("categories", category.getList());
			request.setAttribute("fiction", fiction);
			request.setAttribute("mythology", mythology);
			request.setAttribute("newlist", newList);
			request.setAttribute("textbook", textBook);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
	}
}
