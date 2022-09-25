package com.cab.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ContactUs {
 
	private String firstName;
	private String lastName;
	private String email;
	private String message;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ContactUs [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", message="
				+ message + "]";
	}
	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactUs(String firstName, String lastName, String email, String message) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.message = message;
	}
}
