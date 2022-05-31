package bookshop.credentials.appuser.address;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.credentials.appuser.AppUserService;

@WebServlet("/action-add-address")
public class AddressServlet extends HttpServlet{
	
	private AppUserService appUserService = new AppUserService();
	private AddressService addressService = new AddressService();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = (String) request.getSession().getAttribute("username");
		
		if(username == null) {
			response.sendRedirect("/bookshop/Index");
			return;
		}
		
		int id = appUserService.getAppUser(username).getId();
		
		int houseNo = Integer.parseInt(request.getParameter("houseno"));
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		
		addressService.add(new Address(id, houseNo, street, city, state, country));
		
		response.sendRedirect("/bookshop/Payment");
	}
}
