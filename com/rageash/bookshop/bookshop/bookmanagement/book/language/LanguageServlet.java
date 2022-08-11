package bookshop.bookmanagement.book.language;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/action-addlanguage")
public class LanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Language language = new Language();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String languageName = request.getParameter("language");
		String message = "Language is already added";
		
		if(language.add(languageName) == false)
			request.setAttribute("message", message);
		
		request.getRequestDispatcher("/Adminhome?view=language").forward(request, response);
	}

}
