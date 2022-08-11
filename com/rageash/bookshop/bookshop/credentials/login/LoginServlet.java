package bookshop.credentials.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/action-login")
public class LoginServlet extends HttpServlet{

	private LoginService loginService = new LoginService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if(loginService.acceptUserAuthentication(username, password)) {
			req.getSession().setAttribute("username", username);
			res.sendRedirect("/bookshop/Index");
			
		}else if(loginService.acceptAdminAuthentication(username, password)) {
			req.getSession().setAttribute("adminname", username);
			res.sendRedirect("/bookshop/Adminhome");
			
		}else {
			req.setAttribute("message", "Invalid Username and Password");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}
}