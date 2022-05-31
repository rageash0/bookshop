package bookshop.bookmanagement.book.wholesale.wholesalebook;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bookshop.bookmanagement.book.Book;
import bookshop.credentials.appuser.AppUserService;

@SuppressWarnings("serial")
@WebServlet("/action-addwholesalebook")
public class WholesalebookServlet extends HttpServlet {
	
	private AppUserService appUserService = new AppUserService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String username = (String) request.getSession().getAttribute("username");
		List<WholesaleBook> wholesaleBooks = (List<WholesaleBook>) request.getSession().getAttribute("wholesalebooks");
		String message = "Invalid book details";
		
		if(username == null) {
			response.sendRedirect("/bookshop/Index");
			return;
		}
		
		if(wholesaleBooks == null)
			wholesaleBooks = new ArrayList<WholesaleBook>();
		
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		
		try {
			List<FileItem> fileItem = sf.parseRequest(request);
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
			
			
			wholesaleBooks.add(new WholesaleBook(new Book(isbn, 
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
											language)));
			
			request.getSession().setAttribute("wholesalebooks", wholesaleBooks);
			response.sendRedirect("/bookshop/Wholesale");
			
		} catch (FileUploadException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", message);
			request.getRequestDispatcher("/Wholesale").forward(request, response);
		}
	}
	
	public void notWorking(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String username = (String) request.getSession().getAttribute("username");
		List<WholesaleBook> wholesaleBooks = (List<WholesaleBook>) request.getSession().getAttribute("wholesalebooks");
		String message = "Invalid book details";
		
		if(username == null) {
			response.sendRedirect("/bookshop/Index");
			return;
		}
		
		if(wholesaleBooks == null)
			wholesaleBooks = new ArrayList<WholesaleBook>();
		
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		
		try {
			List<FileItem> fileItem = sf.parseRequest(request);
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
			
			
			wholesaleBooks.add(new WholesaleBook(new Book(isbn, 
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
											language)));
			
			request.getSession().setAttribute("wholesalebooks", wholesaleBooks);
			request.getRequestDispatcher("/Wholesale").forward(request, response);
			
		} catch (FileUploadException | SQLException | ServletException e) {
			e.printStackTrace();
			request.setAttribute("message", message);
			request.getRequestDispatcher("/Wholesale").forward(request, response);
		}
	}

}
