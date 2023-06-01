package com.softuni.registerform.service;

import org.springframework.stereotype.Service;

import com.softuni.registerform.domain.entity.RolesEntity;
import com.softuni.registerform.domain.enums.Roles;
import com.softuni.registerform.repository.RoleRepository;

@Service
public class InitService {
	private final RoleRepository roleRepository;

	public InitService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public void initRoles() {
		if (this.roleRepository.count() < 1) {
			RolesEntity studentRole = new RolesEntity().setRole(Roles.STUDENT);
			RolesEntity teacherRole = new RolesEntity().setRole(Roles.TEACHER);

			this.roleRepository.save(studentRole);
			this.roleRepository.save(teacherRole);
		}
	}
}
