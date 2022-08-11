package bookshop.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.credentials.appuser.AppUserService;

@WebServlet("/action-edituser")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AppUserService appUserService = new AppUserService();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String mobileNumber = request.getParameter("mobilenumber");
		
		if(username == null) {
			response.sendRedirect("/bookshop/Login");
			return;
		}
		
		appUserService.update(appUserService.getAppUser(username).getId(), 
								firstName, lastName, dob, email, mobileNumber);
		
		response.sendRedirect("/bookshop/Profile");
	}
}