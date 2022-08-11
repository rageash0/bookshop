package bookshop.credentials.admin;

public class AuthenticatedAdmin extends Admin{
	
	private String password;

	public AuthenticatedAdmin(String firstName,
							String lastName,
							String adminName,
							String password) {
		
		super(firstName, lastName, adminName);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
