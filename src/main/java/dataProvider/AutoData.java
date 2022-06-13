package dataProvider;

public class AutoData {
	
	private String zipCode;
	private String zipCode2;
	private String insuranceType;
	private String firstName;
	private char middleName;
	private String lastName;
	private String dob;
	private String email;
	private String address;
	private String city;
	private String state;
	private String zipCode3;
	private String year;
	
	public AutoData(String zipCode, String zipCode2, String insuranceType, String firstName, char middleName,
			String lastName, String dob, String email, String address, String city, String state, String zipCode3,
			String year) {
		this.zipCode = zipCode;
		this.zipCode2 = zipCode2;
		this.insuranceType = insuranceType;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode3 = zipCode3;
		this.year = year;
	}


	public String getZipCode() {
		return zipCode;
	}


	public String getZipCode2() {
		return zipCode2;
	}


	public String getInsuranceType() {
		return insuranceType;
	}


	public String getFirstName() {
		return firstName;
	}


	public char getMiddleName() {
		return middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getDob() {
		return dob;
	}


	public String getEmail() {
		return email;
	}


	public String getAddress() {
		return address;
	}


	public String getCity() {
		return city;
	}


	public String getState() {
		return state;
	}


	public String getZipCode3() {
		return zipCode3;
	}


	public String getYear() {
		return year;
	}
	
}
