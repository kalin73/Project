package com.softuni.registerform.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserRegisterForm {
	
	@Size(min = 4, max = 15)
	private String username;
	
	@Size(min = 4)
	private String password;

	@Email
	private String email;

	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
