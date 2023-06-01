package com.softuni.registerform.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.softuni.registerform.domain.dto.RoleDto;
import com.softuni.registerform.domain.entity.RolesEntity;
import com.softuni.registerform.domain.enums.Roles;
import com.softuni.registerform.repository.RoleRepository;

@Service
public class RoleService {
	private final RoleRepository roleRepository;
	private final ModelMapper modelMapper;

	public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
		this.roleRepository = roleRepository;
		this.modelMapper = modelMapper;
	}

	public List<RoleDto> getAllRoles() {
		List<RoleDto> roles = this.roleRepository.findAll().stream().map(role -> modelMapper.map(role, RoleDto.class))
				.toList();

		return roles;
	}

	public RoleDto getRoleByRoleName(Roles roleName) {
		RolesEntity role = this.roleRepository.findAllByRole(roleName);

		return modelMapper.map(role, RoleDto.class);
	}
}
