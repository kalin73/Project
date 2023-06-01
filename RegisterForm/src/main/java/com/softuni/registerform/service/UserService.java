package com.softuni.registerform.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.softuni.registerform.domain.dto.UserRegisterForm;
import com.softuni.registerform.domain.entity.RolesEntity;
import com.softuni.registerform.domain.entity.UserEntity;
import com.softuni.registerform.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final RoleService roleService;
	private final ModelMapper modelMapper;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder,
			RoleService roleService) {
		this.userRepository = userRepository;
		this.roleService = roleService;
		this.modelMapper = modelMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public void registerUser(UserRegisterForm userForRegister) {
		UserEntity user = modelMapper.map(userForRegister, UserEntity.class);
		user.setPassword(passwordEncoder.encode(userForRegister.getPassword()));

		RolesEntity role = modelMapper.map(this.roleService.getRoleByRoleName(user.getRole().getRole()),
				RolesEntity.class);

		user.setRole(role);

		if (this.userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new IllegalArgumentException("Username exists!");
		}

		this.userRepository.save(user);
	}

	public boolean checkEmail(String email) {
		boolean isPresent = this.userRepository.findByEmail(email).isPresent();	
		
		return isPresent;
	}
	
	public void changePassword(String password, String userEmail) {
		UserEntity user = this.userRepository.findByEmail(userEmail).get();
		
		user.setPassword(passwordEncoder.encode(password));
		
		this.userRepository.save(user);		
	}
}
