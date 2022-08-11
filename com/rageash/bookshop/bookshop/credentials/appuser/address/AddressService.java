package bookshop.credentials.appuser.address;

import java.util.List;

public class AddressService {

	private AddressDao addressDao = new AddressDao();
	
	public boolean add(Address address) {
		return addressDao.addRecord(address);
	}
	
	public List<Address> getAll() {
		return addressDao.selectAll();
	}
	
	public List<Address> getByUserId(int userId){
		return addressDao.selectByUserId(userId);
	}
	
	public Address getById(int id){
		return addressDao.selectById(id);
	}
}
