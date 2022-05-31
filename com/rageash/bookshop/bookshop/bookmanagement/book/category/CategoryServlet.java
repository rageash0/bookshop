package bookshop.bookmanagement.book.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/action-addcategory")
public class CategoryServlet extends HttpServlet {
	
	private Category category = new Category();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String categoryName = request.getParameter("category");
		String message = "Category name is already added";
		
		if(category.add(categoryName) == false)
			request.setAttribute("message", message);
		
		request.getRequestDispatcher("/Adminhome?view=category").forward(request, response);
	}

}
