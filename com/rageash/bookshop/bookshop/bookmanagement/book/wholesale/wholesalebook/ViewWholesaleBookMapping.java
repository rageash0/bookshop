package bookshop.bookmanagement.book.wholesale.wholesalebook;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.credentials.appuser.AppUserService;

@WebServlet("/ViewWholesaleBook")
public class ViewWholesaleBookMapping extends HttpServlet {
	
	private WholesaleBookService wholesaleBookService = new WholesaleBookService();
	private AppUserService appUserService = new AppUserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int noOfBooks = Integer.parseInt(request.getParameter("noofbooks"));
		int sellerId = Integer.parseInt(request.getParameter("sellerid"));
		@SuppressWarnings("deprecation")
		BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request.getParameter("price"))).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		int userId = -1;
		String username = (String) request.getSession().getAttribute("username");
		if(username != null)
			userId = appUserService.getAppUser(username).getId();
		
		if(userId == sellerId)
			request.setAttribute("isseller", true);
			
		request.setAttribute("wholesalebooklist", wholesaleBookService.getByWholesaleId(id));
		request.setAttribute("noofbooks", noOfBooks);
		request.setAttribute("price", price);
		request.setAttribute("wholesaleid", id);
		request.getRequestDispatcher("viewwholesalebook.jsp").forward(request, response);
	}

}
