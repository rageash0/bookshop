package bookshop.credentials.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/action-register")
public class Registration extends HttpServlet{
	
	private RegistrationService registrationService = new RegistrationService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String dob = req.getParameter("dob");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String mobileNumber = req.getParameter("mobilenumber");

		boolean passed = registrationService.update(firstName,
													lastName,
													dob,
													username,
													password,
													email,
													mobileNumber);
		
		if(passed) {
			req.getSession().setAttribute("username", username);
			res.sendRedirect("/bookshop/Index");
		}else {
			req.setAttribute("message", "Invalid user details please give required details or username already taken");
			req.getRequestDispatcher("register.jsp").forward(req, res);
		}
	}
}
