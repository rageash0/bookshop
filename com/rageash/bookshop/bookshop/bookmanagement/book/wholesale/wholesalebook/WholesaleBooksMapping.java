package bookshop.bookmanagement.book.wholesale.wholesalebook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.wholesale.WholesaleService;

@WebServlet("/WholesaleBooks")
public class WholesaleBooksMapping extends HttpServlet {
	
	private WholesaleService wholesaleService = new WholesaleService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("wholesalelist", wholesaleService.getAll());
		request.getRequestDispatcher("wholesalebooks.jsp").forward(request, response);
	}

}
