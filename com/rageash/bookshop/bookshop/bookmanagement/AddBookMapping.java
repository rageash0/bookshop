package bookshop.bookmanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.category.Category;
import bookshop.bookmanagement.book.language.Language;

@SuppressWarnings("serial")
@WebServlet("/AddBook")
public class AddBookMapping extends HttpServlet{
	
	private Category categories = new Category();
	private Language language = new Language();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		String username = (String) request.getSession().getAttribute("username");
		
		if(username == null)
			response.sendRedirect("/bookshop/Login");
		else {
			request.setAttribute("categories", categories.getList());
			request.setAttribute("languages", language.getList());
			request.getRequestDispatcher("addbook.jsp").forward(request, response);
		}
	}
}
