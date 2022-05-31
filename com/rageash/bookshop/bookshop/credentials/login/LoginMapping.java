package bookshop.credentials.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Login")
public class LoginMapping extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		String username = (String) request.getSession().getAttribute("username");
		String adminName = (String) request.getSession().getAttribute("adminname");
		
		if(username != null)
			response.sendRedirect("/bookshop/Userhome");
		else if(adminName != null)
			response.sendRedirect("/bookshop/Adminhome");
		else
			request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
