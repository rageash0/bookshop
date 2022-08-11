package bookshop.requestbook.requestedbooks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.requestbook.RequestBook;
import bookshop.requestbook.RequestBookService;

@WebServlet("/RequestedBooks")
public class RequestedBooks extends HttpServlet{
	
	private RequestBookService requestBookService = new RequestBookService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<RequestBook> requestBookList = requestBookService.getAllRequest();
		List<RequestedBook> requestedBooks = new ArrayList<RequestedBook>();
		
		l:
		for(RequestBook list : requestBookList) {
			
			for(RequestedBook requestedList : requestedBooks) {
				
				if(list.getIsbn() == requestedList.getRequestBook().getIsbn()) {
					requestedList.increaseCount();
					continue l;
				}
			}
			
			requestedBooks.add(new RequestedBook(list, 1));
		}
		
		request.setAttribute("requestedList", requestedBooks);
		request.getRequestDispatcher("requestedbooks.jsp").forward(request, response);
	}
}
