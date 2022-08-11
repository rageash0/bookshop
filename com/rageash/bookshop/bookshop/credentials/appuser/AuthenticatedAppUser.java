package bookshop.credentials.appuser;

public class AuthenticatedAppUser extends AppUser {
	
	private String password;
	
	public AuthenticatedAppUser(AppUser appUser, String password) {
		super(appUser);
		setPassword(password);
	}

	String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}
	
}
