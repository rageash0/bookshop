package bookshop.credentials.appuser;

import java.sql.Date;
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

	public void update(int id,
						String firstName, 
						String lastName, 
						String dob, 
						String email, 
						String mobileNumber) {

		AppUser user = getAppUser(id);
		
		if(firstName != null 
				&& firstName.length() > 0 
				&& !firstName.equals(user.getFirstName()))
			appUserDao.updateFirstName(id, firstName);
		
		if(lastName != null 
				&& lastName.length() > 0 
				&& !lastName.equals(user.getLastName()))
			appUserDao.updateLastName(id, lastName);
		
		if(dob != null 
				&& dob.length() > 0
				&& user.getDob().equals(Date.valueOf(dob)))
			appUserDao.updateDob(id, Date.valueOf(dob));
		
		if(email != null 
				&& email.length() > 0
				&& email.equals(user.getEmail()))
			appUserDao.updateEmail(id, email);
		
		if(mobileNumber != null 
				&& mobileNumber.length() > 0
				&& mobileNumber.equals(user.getMobileNumber()))
			appUserDao.updateMobileNumber(id, mobileNumber);
	}
	
	public void updatePassword(String username, String oldPassword, String newPassword) {
		if(appUserDao.selectByCredential(username, oldPassword) != null)
			appUserDao.updatePassword(getAppUser(username).getId(), newPassword);
	}
	
	public boolean deleteUser(int id) {
		return appUserDao.delete(id);
	}
}
