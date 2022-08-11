package bookshop.requestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/action-requestbook")
public class RequestBookServlet extends HttpServlet{
	
	private RequestBookService requestBookService = new RequestBookService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long isbn = Long.parseLong(request.getParameter("isbn"));
		String bookName = request.getParameter("bookname");
		String author = request.getParameter("author");
		String edition = request.getParameter("edition");
		String applicantName = request.getParameter("applicantname");
		
		requestBookService.submit(new RequestBook(isbn, bookName, author, edition, applicantName));
		
		request.getRequestDispatcher("request_successful.jsp").forward(request, response);
	}
}
