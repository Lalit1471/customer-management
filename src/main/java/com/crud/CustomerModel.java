package com.crud;

public class CustomerModel {
	public String firstname;
	public String lastname;
	public String street;
	public String address;
	public String phone_number;
	public String email;
	public String city;
	public String state;
	
	public CustomerModel() {
		
	}
	
	public CustomerModel(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public void setvalues(String firstname, String lastname, String street, String address, String phone_number, String email, String city, String state) {
		if(firstname != null) {
			this.firstname = firstname;
		}
		if(lastname != null) {
			this.lastname = lastname;
		}
		if(street != null) {
			this.street = street;
		}
		if(address != null) {
			this.address = address;
		}
		if(phone_number != null) {
			this.phone_number = phone_number;
		}
		if(city != null) {
			this.city = city;
		}
		if(state != null) {
			this.state = state;
		}
		if(email != null) {
			this.email = email;
		}
	}
	
	public String getfname() {
		return this.firstname;
	}
	public String getlname() {
		return this.lastname;
	}
	public String getphone() {
		return this.phone_number;
	}
	public String getstreet() {
		return this.street;
	}
	public String getcity() {
		return this.city;
	}
	public String getaddress() {
		return this.address;
	}
	public String getemail() {
		return this.email;
	}
	public String getstate() {
		return this.state;
	}
	
}
