package com.jspiders.designpatterns.creational;

public class ContactBuilder {

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

	public ContactBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public ContactBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactBuilder setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public ContactBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactBuilder setDob(String dob) {
		this.dob = dob;
		return this;
	}

	public ContactBuilder setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public ContactBuilder setMobile(long mobile) {
		this.mobile = mobile;
		return this;
	}

	public ContactBuilder setWork(long work) {
		this.work = work;
		return this;
	}

	public ContactBuilder setLandLine(int landLine) {
		this.landLine = landLine;
		return this;
	}

	public ContactBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactBuilder setWebsite(String website) {
		this.website = website;
		return this;
	}

	public ContactBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	public Contact buildContact() {
		return new Contact(id, firstName, middleName, lastName, dob, gender, 
				mobile, work, landLine, email, website,
				address);
	}

}
