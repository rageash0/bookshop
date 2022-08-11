	package bookshop.bookmanagement.book.addtocart;
	
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import bookshop.credentials.appuser.AppUserService;
	
	/**
	 * Servlet implementation class AddToCartServlet
	 */
	@WebServlet("/action-addtocart")
	public class AddToCartServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		private AppUserService appUserService = new AppUserService();
		private AddToCartService addToCartService = new AddToCartService();
	  
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String username = (String) request.getSession().getAttribute("username");
			int bookId = Integer.parseInt(request.getParameter("bookid"));
			
			if(username == null)
				response.sendRedirect("/bookshop/Login");
			else {
	
				
				int id = appUserService.getAppUser(username).getId();
				
				addToCartService.addToCart(bookId, id);
	
				response.sendRedirect("/bookshop/Viewbook?id=" +bookId);
			}
		}
	
	}
