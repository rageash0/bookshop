package bookshop.credentials.admin;

public class Admin {
	 
	private String firstName;
	private String lastName;
	private String username;
	
	public Admin(String firstName, 
					String lastName, 
					String username) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAdminName() {
		return username;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
