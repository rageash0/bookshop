package bookshop.bookmanagement;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bookmanagement.book.Book;
import bookshop.bookmanagement.book.BookService;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBook;
import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBookService;

@SuppressWarnings("serial")
@WebServlet("/picture")
public class PictureProjection extends HttpServlet{
	
	private BookService bookService = new BookService();
	private WholesaleBookService wholesaleBookService = new WholesaleBookService();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String bookId = req.getParameter("id");
		String wholesaleBookId = req.getParameter("wid");
		Book book;
		
		if(bookId != null)
			book = bookService.getBook(Integer.parseInt(bookId));
		else
			book = wholesaleBookService.getByBookId(Integer.parseInt(wholesaleBookId)).getBook();

		try {
			
			byte[] imageByte = book.getImage()
									.getBinaryStream()
									.readAllBytes();
			
			//output
			res.getOutputStream()
				.write(imageByte);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
