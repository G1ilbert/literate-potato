package Packgage.lab7_1;

public class Employees {

	protected String firstName; 
	protected String lastName; 
	protected String securityNumber;
	
	public Employees(String first, String last, String ssn) { 
		firstName = first;
	    lastName = last;
	    securityNumber = ssn;
	}
	
	public String toString() {
	return String.format("%s %s\nsocial security number: %s", firstName, lastName, securityNumber);
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getssn() {
		return securityNumber;
	}

	public void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}
}
