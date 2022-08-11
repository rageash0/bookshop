package bookshop.credentials.appuser.address;

public class Address {

	private int id;
	private int userId;
	private int houseNo;
	private String street;
	private String city;
	private String state;
	private String country;
	
	public Address(int userId, 
					int houseNo, 
					String street, 
					String city, 
					String state, 
					String country) {
		
		setUserId(userId);
		setHouseNo(houseNo);
		setStreet(street);
		setCity(city);
		setState(state);
		setCountry(country);
	}
	
	public Address(int id, 
					int userId, 
					int houseNo, 
					String street, 
					String city, 
					String state, 
					String country) {
		
		this(userId, houseNo, street, city, state, country);
		setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
