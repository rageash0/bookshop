package bookshop.credentials.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Register")
public class RegisterMapping extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		String username = (String) request.getSession().getAttribute("username");
		String adminName = (String) request.getSession().getAttribute("adminname");
		
		if(username != null)
			response.sendRedirect("/bookshop/Userhome");
		else if(adminName != null)
			response.sendRedirect("/bookshop/Adminhome");
		else
			request.getRequestDispatcher("register.jsp").forward(request, response);
	}

}
