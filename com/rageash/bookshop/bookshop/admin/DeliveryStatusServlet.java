package bookshop.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.transaction.TransactionService;

@WebServlet("/action-setdeliverystatus")
public class DeliveryStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private TransactionService transactionService = new TransactionService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("a"));
		
		String tid = request.getParameter("id");
		String wid = request.getParameter("wid");
		
		String status;
		
		if(a==1) status = "Packed";
		else if(a==2) status = "Dispatched";
		else if(a==3) status = "Out for order";
		else status = "Delivered";
		
		if(tid != null) {
			transactionService.setBookDeliveryStatus(status, Integer.parseInt(tid));
			response.sendRedirect("/bookshop/Adminhome?view=transaction");
		}
		else {
			transactionService.setWholesaleDeliveryStatus(status, Integer.parseInt(wid));
			response.sendRedirect("/bookshop/Adminhome?view=wholesale");
		}
		
	}

}
