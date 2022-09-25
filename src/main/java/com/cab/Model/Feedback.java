package com.cab.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback {
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	private int id;

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userId=" + userId + ", username=" + username + ", email=" + email
				+ ", message=" + message + "]";
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int id, int userId, String username, String email, String message) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.message = message;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	private int userId;
	private String username;
	private String email;
	private String message;
}
