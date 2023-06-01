package com.softuni.registerform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softuni.registerform.domain.entity.RolesEntity;
import com.softuni.registerform.domain.enums.Roles;

public interface RoleRepository extends JpaRepository<RolesEntity, Long> {
	RolesEntity findAllByRole(Roles role);
}
