package bookshop.bookmanagement.book.wholesale;

import java.util.List;

import bookshop.bookmanagement.book.wholesale.wholesalebook.WholesaleBookService;

public class WholesaleService {

	private WholesaleDao wholesaleDao = new WholesaleDao();
	private WholesaleBookService wholesaleBookService = new WholesaleBookService();
	
	public boolean add(Wholesale wholesale) {
		
		if(wholesaleDao.selectByName(wholesale.getName()) != null)
			return false;
			
		return wholesaleDao.addRecord(wholesale);
	}
	
	public List<Wholesale> getBySellerId(int sellerId){
		return wholesaleDao.selectBySellerId(sellerId);
	}
	
	public List<Wholesale> getAll(){
		return wholesaleDao.selectAll();
	}
	
	public Wholesale getById(int id) {
		return wholesaleDao.selectById(id);
	}
	
	public Wholesale getByName(String name) {
		return wholesaleDao.selectByName(name);
	}

	public boolean remove(int wholesaleId) {
		wholesaleBookService.remove(wholesaleId);
		return wholesaleDao.removeRecord(wholesaleId);
	}
}
