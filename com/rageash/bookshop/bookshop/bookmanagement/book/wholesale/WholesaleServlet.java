package bookshop.bookmanagement.book.wholesale;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBook;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBookService;
import bookshop.credentials.appuser.AppUserService;

@SuppressWarnings("serial")
@WebServlet("/action-addwholesale")
public class WholesaleServlet extends HttpServlet {
	
	private WholesaleService wholesaleService = new WholesaleService();
	private WholesaleBookService wholesaleBookService = new WholesaleBookService();
	private AppUserService appUserService = new AppUserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		List<WholesaleBook> books = (List<WholesaleBook>) request.getSession().getAttribute("wholesalebooks");
		
		String wholesalemessage = "Invalid name or name already taken";
		String noBookMessage = "Please enter more than one book";
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int id = appUserService.getAppUser(username).getId();
		double price = books.stream().map(w -> w.getBook().getPrice()).collect(Collectors.summingDouble(e -> e.doubleValue())); 
		Wholesale wholesale = new Wholesale(name, description, books.size(), BigDecimal.valueOf(price), id);
		
		if(username == null) {
			response.sendRedirect("/bookshop/Index");
			return;
		}
		
		if(books == null || books.size() < 2) {
			request.setAttribute("wholesalemessage", noBookMessage);
			request.getRequestDispatcher("/Wholesale").forward(request, response);
			return;
		}
		
		if(wholesaleService.add(wholesale)) {
			int wid = wholesaleService.getByName(name).getId();
			wholesaleBookService.add(books, wid);
			request.getSession().removeAttribute("wholesalebooks");
			
			response.sendRedirect("/bookshop/Profile");
		}else {
			request.setAttribute("wholesalemessage", wholesalemessage);
			request.getRequestDispatcher("/Wholesale").forward(request, response);
		}
	}

}
