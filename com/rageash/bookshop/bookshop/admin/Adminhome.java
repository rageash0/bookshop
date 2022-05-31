package bookshop.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.category.Category;
import bookshop.bookmanagement.book.language.Language;
import bookshop.credentials.appuser.AppUser;
import bookshop.credentials.appuser.AppUserService;
import bookshop.requestbook.RequestBookService;
import bookshop.transaction.TransactionService;

@WebServlet("/Adminhome")
public class Adminhome extends HttpServlet{
	
	private AppUserService appUserService = new AppUserService();
	private TransactionService transactionService = new TransactionService();
	private RequestBookService requestBookService = new RequestBookService();
	private Category category = new Category();
	private Language language = new Language();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminname = (String) request.getSession().getAttribute("adminname");
		
		if(adminname == null) {
			response.sendRedirect("/bookshop/Index");
			return;
		}
		
		String view = request.getParameter("view");
		
		if(view == null) 
			request.setAttribute("userlist", appUserService.getAllUser());
		else if(view.compareTo("transaction") == 0) 
			request.setAttribute("transactionlist", transactionService.getAll());
		else if(view.compareTo("wholesale") == 0)
			request.setAttribute("wholesalelist", transactionService.getAllWholesale());
		else if(view.compareTo("requestedbook") == 0)
			request.setAttribute("requestedbooklist", requestBookService.getAllRequest());
		else if(view.compareTo("category") == 0)
			request.setAttribute("categorylist", category.getList());
		else if(view.compareTo("language") == 0)
			request.setAttribute("languagelist", language.getList());
		
		
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
	}
}