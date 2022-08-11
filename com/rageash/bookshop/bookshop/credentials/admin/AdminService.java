package bookshop.credentials.admin;

public class AdminService {
	
	private AdminDao adminDao = new AdminDao();
	
	public boolean isAdmin(String adminName) {
		return adminDao.selectByAdminName(adminName) != null;
	}
	
	public Admin getAdmin(String adminName) {
		return adminDao.selectByAdminName(adminName);
	}
	
	public Admin getAdmin(String adminName, String password) {
		return adminDao.selectByCredential(adminName, password);
	}
	
	@Deprecated
	public boolean register(AuthenticatedAdmin authenticatedAdmin) {
		return adminDao.add(authenticatedAdmin);
	}
}
