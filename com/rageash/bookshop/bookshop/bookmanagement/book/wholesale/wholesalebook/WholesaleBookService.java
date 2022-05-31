package bookshop.bookmanagement.book.wholesale.wholesalebook;

import java.util.List;

public class WholesaleBookService {

	private WholesaleBookDao wholesaleBookDao = new WholesaleBookDao();
	
	public boolean add(List<WholesaleBook> wholesaleBooks, int wholesaleId) {
		return wholesaleBookDao.addRecord(wholesaleBooks, wholesaleId);
	}
	
	public List<WholesaleBook> getByWholesaleId(int wholesaleId){
		return wholesaleBookDao.selectByWholesaleId(wholesaleId);
	}
	
	public WholesaleBook getByBookId(int bookId){
		return wholesaleBookDao.selectByBookId(bookId);
	}
	
	public List<WholesaleBook> getAll(){
		return wholesaleBookDao.selectAll();
	}

	public boolean remove(int wholesaleId) {
		return wholesaleBookDao.removeByWholesaleId(wholesaleId);
	}
}
