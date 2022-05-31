package bookshop.bookmanagement.book.wholesale;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.category.Category;
import bookshop.bookmanagement.book.language.Language;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBook;

@SuppressWarnings("serial")
@WebServlet("/Wholesale")
public class WholesaleMapping extends HttpServlet {
	
	private Language language = new Language();
	private Category category = new Category();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String username = (String) request.getSession().getAttribute("username");
		
		if(username == null) {
			response.sendRedirect("/bookshop/Login");
			return;
		}
		
		request.setAttribute("categories", category.getList());
		request.setAttribute("languages", language.getList());
		request.getRequestDispatcher("wholesale.jsp").forward(request, response);
	}
}
