package bookshop.credentials.appuser;

import java.sql.Date;

public class AppUser {
	
	private int id;
	private String firstName;
	private String lastName;
	private Date dob;
	private String username;
	private String email;
	private String mobileNumber;
	
	public AppUser(int id,
					String firstName,
					String lastName,
					Date dob,
					String username,
					String email,
					String mobileNumber) {
		this.id = id;
		setFirstName(firstName);
		setLastName(lastName);
		setDob(dob);
		setUsername(username);
		setEmail(email);
		setMobileNumber(mobileNumber);
	}
	
	public AppUser(AppUser user) {
		this(user.getId(),
				user.getFirstName(), 
				user.getLastName(),
				user.getDob(),
				user.getUsername(),
				user.getEmail(),
				user.getMobileNumber());
	}
	
	public int getId() {	return id;	}

	public String getFirstName(){	return firstName;	}
	
	public String getLastName()	{	return lastName;	}
	
	public Date getDob()	{	return dob;			}
	
	public String getUsername()	{	return username;	}
	
	public String getEmail()	{	return email;		}
	
	public String getMobileNumber()	{	return mobileNumber;}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
