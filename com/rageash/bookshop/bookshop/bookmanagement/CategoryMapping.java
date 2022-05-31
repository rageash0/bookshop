package bookshop.bookmanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.Book;
import bookshop.bookmanagement.book.BookService;
import bookshop.bookmanagement.book.category.Category;

@WebServlet("/Categories")
public class CategoryMapping extends HttpServlet {
	
	private Category categories = new Category();
	private BookService bookService = new BookService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category = request.getParameter("name");
		List<Book> books = new ArrayList<Book>();
		
		if(category == null || category.compareTo("all") == 0) {
			books = bookService.getAllBooks();
			request.setAttribute("categoryname", "All");
		}else {
			books = bookService.getBooksByCategory(category);
			request.setAttribute("categoryname", category);
		}
		
		request.setAttribute("booklist", books);
		request.setAttribute("categories", categories.getList());
		request.getRequestDispatcher("categories.jsp").forward(request, response);
	}
}
