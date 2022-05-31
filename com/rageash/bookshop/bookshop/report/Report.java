package bookshop.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import bookshop.transaction.TransactionDetails;
import bookshop.transaction.TransactionService;

@SuppressWarnings("serial")
@WebServlet("/Report")
public class Report extends HttpServlet{
	
	private TransactionService transactionService = new TransactionService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		final Path BASE_PATH = Paths.get(System.getProperty("user.home") + "\\Documents");
		final Path FILE_DIRECTORY = BASE_PATH.resolve("Bookshop");
		final String FILENAME = "REPORT.PDF";
		
		Document document = new Document(PageSize.A4.rotate());
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(Files.createDirectories(FILE_DIRECTORY).resolve(FILENAME).toString()));
			
			document.open();
			
			PdfPTable table = new PdfPTable(16);
			table.setWidthPercentage(100);
			Font font = new Font(FontFamily.COURIER, 8);
			PdfPCell id = new PdfPCell(new Phrase("Id", font));
			PdfPCell isbn = new PdfPCell(new Phrase("ISBN", font));
			PdfPCell bookName = new PdfPCell(new Phrase("Book Name", font));
			PdfPCell author = new PdfPCell(new Phrase("Author", font));
			PdfPCell edition = new PdfPCell(new Phrase("Edition", font));
			PdfPCell publisher = new PdfPCell(new Phrase("Publisher", font));
			PdfPCell price = new PdfPCell(new Phrase("Price", font));
			PdfPCell sellerName = new PdfPCell(new Phrase("Seller name", font));
			PdfPCell buyerName = new PdfPCell(new Phrase("Buyer name", font));
			PdfPCell houseNo = new PdfPCell(new Phrase("House No", font));
			PdfPCell street = new PdfPCell(new Phrase("Street", font));
			PdfPCell city = new PdfPCell(new Phrase("City", font));
			PdfPCell state = new PdfPCell(new Phrase("State", font));
			PdfPCell country = new PdfPCell(new Phrase("Country", font));
			PdfPCell date = new PdfPCell(new Phrase("Date", font));
			PdfPCell payment = new PdfPCell(new Phrase("Payment", font));
			
			table.addCell(id);
			table.addCell(isbn);
			table.addCell(bookName);
			table.addCell(author);
			table.addCell(edition);
			table.addCell(publisher);
			table.addCell(price);
			table.addCell(sellerName);
			table.addCell(buyerName);
			table.addCell(houseNo);
			table.addCell(street);
			table.addCell(city);
			table.addCell(state);
			table.addCell(country);
			table.addCell(date);
			table.addCell(payment);
			
			table.setHeaderRows(1);
			
			for(TransactionDetails td : transactionService.getAll()) {
				table.addCell(new Phrase(td.getId() + "", font));
				table.addCell(new Phrase(td.getIsbn() + "", font));
				table.addCell(new Phrase(td.getBookName() + "", font));
				table.addCell(new Phrase(td.getAuthor() + "", font));
				table.addCell(new Phrase(td.getEdition() + "", font));
				table.addCell(new Phrase(td.getPublisher() + "", font));
				table.addCell(new Phrase(td.getPrice() + "", font));
				table.addCell(new Phrase(td.getSellerName() + "", font));
				table.addCell(new Phrase(td.getBuyerName() + "", font));
				table.addCell(new Phrase(td.getHouseNo() + "", font));
				table.addCell(new Phrase(td.getStreet() + "", font));
				table.addCell(new Phrase(td.getCity() + "", font));
				table.addCell(new Phrase(td.getState() + "", font));
				table.addCell(new Phrase(td.getCountry() + "", font));
				table.addCell(new Phrase(td.getDate() + "", font));
				table.addCell(new Phrase(td.getPayment() + "", font));
			}
			
			document.add(table);
			
			document.close();	
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/bookshop/Adminhome?view=transaction");
	}
}
