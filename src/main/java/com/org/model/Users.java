package com.org.model;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	
	private String userType;
	
	@Id
	private BigInteger userId;
	
	@NotNull
	@Size(min = 2, max = 50)
	private String userName;
	
	@NotNull
	@Size(min = 8, max = 0)
	private String userPassword;
	
	@NotNull
	private BigInteger userPhone;
	
	@NotNull
	@Email
	private String userEmail;

	// Constructor with parameters
	public Users(String userName, String userPassword, BigInteger userPhone, String userEmail, String userType,
			BigInteger userId) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userType = userType;
		this.userId = userId;
	}

	// Default constructor
	public Users() {
	}

	// Getters and Setters
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public BigInteger getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(BigInteger userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
