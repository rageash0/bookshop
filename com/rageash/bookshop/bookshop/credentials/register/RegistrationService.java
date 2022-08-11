package bookshop.credentials.register;

import java.sql.Date;

import bookshop.credentials.appuser.AppUser;
import bookshop.credentials.appuser.AppUserService;
import bookshop.credentials.appuser.AuthenticatedAppUser;

public class RegistrationService {
	
	private AppUserService appUserService = new AppUserService();

	public boolean update(String firstName,
							String lastName,
							String dob,
							String username,
							String password,
							String email,
							String mobileNumber) {
		
		AppUser user = new AppUser(0,					//on purpose
									firstName,
									lastName,
									Date.valueOf(dob),
									username,
									email,
									mobileNumber);
			
		return appUserService.register(new AuthenticatedAppUser(user, password));
	}
}
