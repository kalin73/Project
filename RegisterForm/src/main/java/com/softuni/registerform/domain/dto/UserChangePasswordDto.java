package com.softuni.registerform.domain.dto;

public class UserChangePasswordDto {
	private String email;

	public UserChangePasswordDto() {

	}

	public UserChangePasswordDto(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
