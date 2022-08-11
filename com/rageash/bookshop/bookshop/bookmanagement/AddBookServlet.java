package bookshop.bookmanagement;

import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.sql.rowset.serial.SerialBlob;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import bookshop.credentials.appuser.AppUserService;

import bookshop.bookmanagement.book.*;
import org.apache.commons.fileupload.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;

@SuppressWarnings("serial")
@WebServlet("/action-addbook")
public class AddBookServlet extends HttpServlet{
	
	final private String message = "Invalid details please specify the correct fields";
	private BookService bookService = new BookService();
	private AppUserService appUserService = new AppUserService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String username = (String) req.getSession().getAttribute("username");
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> fileItem = sf.parseRequest(req);
			String[] list = new String[10];
			InputStream inputStream = null;
			int i = 0;
			
			for(Iterator<FileItem> iterator = fileItem.iterator(); iterator.hasNext();) {
				FileItem item = iterator.next();
				if(item.isFormField())
					list[i++] = item.getString();
				else
					inputStream = item.getInputStream();
			}
			
			int sellerId = appUserService.getAppUser(username).getId();
			long isbn = Long.parseLong(list[0]);
			String name = list[1];
			String author = list[2];
			String publisher = list[3];
			String edition = list[4];
			int page = list[5].length() <=0 ? 0 : Integer.parseInt(list[5]);
			BigDecimal price = BigDecimal.valueOf(Double.valueOf(list[6]));
			Blob cover = new SerialBlob(inputStream.readAllBytes());
			String description = list[7];
			String category = list[8];
			String language = list[9];
			
			
			if(bookService.add(	new Book(isbn, 
											name, 
											author, 
											publisher, 
											edition, 
											page, 
											price, 
											cover, 
											description,
											sellerId,
											category,
											language)))
				res.sendRedirect("/bookshop/Profile");
			else {
				req.setAttribute("message", message);
				req.getRequestDispatcher("/AddBook").forward(req, res);
			}
			
		} catch (FileUploadException | SQLException | ServletException e) {
			e.printStackTrace();
		}
		
	}
	
}
