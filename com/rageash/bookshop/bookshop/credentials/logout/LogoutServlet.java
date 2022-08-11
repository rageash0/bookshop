package bookshop.credentials.logout;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/action-logout")
public class LogoutServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();

		session.removeAttribute("adminname");
		session.removeAttribute("username");
		
		res.sendRedirect("/bookshop/Index");
	}
}
