package bookshop.bookmanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.transaction.TransactionDetails;
import bookshop.transaction.TransactionService;
import bookshop.transaction.WholesaleTransactionDetails;

@WebServlet("/TrackOrder")
public class TrackOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public TransactionService transaction = new TransactionService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = (String) request.getSession().getAttribute("username");
		
		String id = request.getParameter("id");
		String wid = request.getParameter("wid");
		
		if(username == null) {
			response.sendRedirect("/bookshop/Profile");
			return;
		}
		
		String deliveryStatus = null;
		int rank = 1;

		if(id != null) {
			TransactionDetails transactionDetails = transaction.getByTransactionId(Integer.parseInt(id));
			request.setAttribute("book", transactionDetails);
			deliveryStatus = transactionDetails.getDelivery();
			
		}else if(wid != null) {
			WholesaleTransactionDetails wholesaleTransaction = transaction.getByWholesaleTransactionId(Integer.parseInt(wid));
			request.setAttribute("wholesale", wholesaleTransaction);
			deliveryStatus = wholesaleTransaction.getDelivery();
		}
		
		if(deliveryStatus.compareTo("Delivered") == 0)
			rank = 5;
		else if(deliveryStatus.compareTo("Out for delivery") == 0)
			rank = 4;
		else if(deliveryStatus.compareTo("Dispatched") == 0)
			rank = 3;
		else if(deliveryStatus.compareTo("Packed") == 0)
			rank = 2;
			
		request.setAttribute("delivery", rank);
		request.getRequestDispatcher("trackorder.jsp").forward(request, response);
	}
}
