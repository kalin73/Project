package com.softuni.registerform.domain.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AppUserDetails extends User {
	private static final long serialVersionUID = 1L;
	private String country;
	private String fullName;
	private String email;

	public AppUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String email) {
		super(username, password, authorities);
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public AppUserDetails setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public AppUserDetails setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public AppUserDetails setEmail(String email) {
		this.email = email;
		return this;
	}

}
