package bookshop.credentials.appuser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppUserService {
	
	private AppUserDao appUserDao = new AppUserDao();
	
	public boolean isUser(String username) {
		return getAppUser(username) != null;
	}
	
	public AppUser getAppUser(int id) {
		return appUserDao.selectById(id);
	}

	public AppUser getAppUser(String username) {
		return appUserDao.selectByUsername(username);
	}
	
	public AppUser getAppUser(String username, String password) {
		return appUserDao.selectByCredential(username, password);
	}
	
	public boolean register(AuthenticatedAppUser authenticatedAppUser) {
		return appUserDao.addRecord(authenticatedAppUser);
	}
	
	public List<AppUser> getAllUser(){
		return appUserDao.selectAll();
	}
	
	public List<AppUser> getUsersById(List<Integer> id){
		List<AppUser> userList = new ArrayList<AppUser>();
		
		for(Iterator<Integer> iterator = id.iterator();iterator.hasNext();)
			userList.add(getAppUser(iterator.next()));
		
		return userList;
	}
}
