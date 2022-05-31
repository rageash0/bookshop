package bookshop.requestbook;

import java.util.List;

public class RequestBookService {

	private RequestBookDao requestBookDao = new RequestBookDao();
	
	public boolean submit(RequestBook requestBook) {
		return requestBookDao.addRecord(requestBook);
	}
	
	public List<RequestBook> getAllRequest(){
		return requestBookDao.selectAll();
	}
}
