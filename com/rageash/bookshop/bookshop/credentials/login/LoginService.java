package bookshop.credentials.login;

import bookshop.credentials.admin.AdminService;
import bookshop.credentials.appuser.AppUserService;

public class LoginService {
	
	private AppUserService appUserService = new AppUserService();
	private AdminService adminService = new AdminService();
	
	public boolean acceptUserAuthentication(String username, String password) {
		return appUserService.getAppUser(username, password) != null;
	}
	
	public boolean acceptAdminAuthentication(String adminName, String password) {
		return adminService.getAdmin(adminName, password) != null;
	}
}