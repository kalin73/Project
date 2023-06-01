package com.softuni.registerform.domain.dto;

import com.softuni.registerform.domain.enums.Roles;

public class RoleDto {
	private Long id;

	private Roles role;

	public Long getId() {
		return id;
	}

	public RoleDto setId(Long id) {
		this.id = id;
		return this;
	}

	public Roles getRole() {
		return role;
	}

	public RoleDto setRole(Roles role) {
		this.role = role;
		return this;
	}

}
