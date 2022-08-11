package bookshop.transaction.payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.Book;
import bookshop.bookmanagement.book.BookService;
import bookshop.bookmanagement.book.addtocart.AddToCartService;
import bookshop.bookmanagement.book.wholesale.WholesaleService;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBook;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBookService;
import bookshop.credentials.appuser.AppUser;
import bookshop.credentials.appuser.AppUserService;
import bookshop.credentials.appuser.address.Address;
import bookshop.credentials.appuser.address.AddressService;
import bookshop.transaction.PlaceTransaction;
import bookshop.transaction.TransactionDetails;
import bookshop.transaction.TransactionService;
import bookshop.transaction.WholesaleBookTransactionDetails;
import bookshop.transaction.WholesaleTransactionDetails;

@SuppressWarnings("serial")
@WebServlet("/action-payment")
public class PaymentServlet extends HttpServlet{
	
	private AppUserService appUserService = new AppUserService();
	private AddressService addressService = new AddressService();
	private PlaceTransaction placeTransaction = new PlaceTransaction();
	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> books = (List<Book>) request.getSession().getAttribute("buyingbooks");
		List<WholesaleBook> wholesaleBook = (List<WholesaleBook>) request.getSession().getAttribute("wholesalelist");
		
		if(books == null && wholesaleBook == null) {
			response.sendRedirect("/bookshop/Profile");
			return;
		}
		
		String cardNumber = request.getParameter("cardnumber");
		String ccv = request.getParameter("ccv");
		String[] monthyear = request.getParameter("monthyear").split("/");
		String pin = request.getParameter("pin");
		
		int month = Integer.parseInt(monthyear[0]);
		int year = Integer.parseInt(monthyear[1]);
		LocalDate today = LocalDate.now();
		
		if(month <= 0 || month > 12 || 
				year < today.getYear() || 
				year == today.getYear() && month < today.getMonthValue()) {
			
			request.setAttribute("message", "Invalid expire date");
			response.sendRedirect("/bookshop/Payment?e=1");
			return;
		}
			
		
		int addressId = Integer.parseInt(request.getParameter("address"));
		Address address = addressService.getById(addressId);
		
		String username = (String) request.getSession().getAttribute("username");
		AppUser buyer = appUserService.getAppUser(username);
		
		if(books != null) {
			if(!placeTransaction.updateBookOrder(books, address, buyer, "Paid")) {
				response.sendRedirect("/bookshop/Profile");
				return;
			}
		}else if(wholesaleBook != null) {
			if(!placeTransaction.updateWholesaleBookOrder(wholesaleBook, address, buyer, "Paid")) {
				response.sendRedirect("/bookshop/Profile");
				return;
			}
		}
		
		request.getSession().removeAttribute("buyingbooks");
		request.getSession().removeAttribute("wholesalelist");
		request.getRequestDispatcher("Payment_Successful.jsp").forward(request, response);
	}
	
	
}
