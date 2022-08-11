package bookshop.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.credentials.appuser.AppUser;
import bookshop.credentials.appuser.AppUserService;
import bookshop.transaction.TransactionDetails;
import bookshop.transaction.TransactionService;

@SuppressWarnings("serial")
@WebServlet("/ViewBuyers")
public class ViewBuyers extends HttpServlet{
	
	private TransactionService transactionService = new TransactionService();
	private AppUserService appUserService = new AppUserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		String username = (String) request.getSession().getAttribute("username");
		
		if(username == null)
			response.sendRedirect("/bookshop/Welcome");
		else {
			
			int userId = appUserService.getAppUser(username).getId();
			
			List<Integer> transactionId = transactionService
													.getBySellerId(userId)
													.stream()
													.map(TransactionDetails::getSellerId)
													.toList();
			
			List<AppUser> buyers = appUserService.getUsersById(transactionId);
			
			request.setAttribute("buyer", buyers);
			request.getRequestDispatcher("viewbuyers.jsp").forward(request, response);
		}
	}
}
