package bookshop.transaction.payment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.Book;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBook;
import bookshop.credentials.appuser.AppUserService;
import bookshop.credentials.appuser.address.AddressService;

@SuppressWarnings("serial")
@WebServlet("/Payment")
public class PaymentMapping extends HttpServlet{
	
	private AddressService addressService = new AddressService();
	private AppUserService appUserService = new AppUserService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		String username = (String) request.getSession().getAttribute("username");
		List<Book> book = (List<Book>) request.getSession().getAttribute("buyingbooks");
		List<WholesaleBook> wholesaleBook = (List<WholesaleBook>) request.getSession().getAttribute("wholesalelist");
		String message = request.getParameter("e");
		
		if(message != null)
			request.setAttribute("message", "Invalid card details");
		
		if(username == null) {
			response.sendRedirect("/bookshop/Login");
			return;
		}else if(book == null && wholesaleBook == null) {
			response.sendRedirect("/bookshop/Profile");
			return;
		} 
		
		int id = appUserService.getAppUser(username).getId();
		
		request.setAttribute("addresslist", addressService.getByUserId(id));
		request.getRequestDispatcher("payment.jsp").forward(request, response);
	}
}
