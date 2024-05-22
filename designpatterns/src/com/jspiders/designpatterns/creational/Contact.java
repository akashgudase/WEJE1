package com.jspiders.designpatterns.creational;

public class Contact {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String gender;
	private long mobile;
	private long work;
	private int landLine;
	private String email;
	private String website;
	private String address;

	public Contact(int id, String firstName, String middleName, String lastName, 
		           String dob, String gender, long mobile,long work, int landLine, 
		           String email, String website, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.mobile = mobile;
		this.work = work;
		this.landLine = landLine;
		this.email = email;
		this.website = website;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName 
				+ ", middleName=" + middleName + ", lastName="+ lastName 
				+ ", dob=" + dob + ", gender=" + gender + ", mobile=" + mobile 
				+ ", work=" + work+ ", landLine=" + landLine + ", email=" + email 
				+ ", website=" + website + ", address=" + address + "]";
	}

}
