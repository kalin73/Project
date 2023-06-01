package com.softuni.registerform.domain.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.softuni.registerform.domain.entity.UserEntity;
import com.softuni.registerform.repository.UserRepository;

public class AuthenticatedUser implements UserDetailsService {
	private final UserRepository userRepository;

	public AuthenticatedUser(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = this.userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));

		return this.map(user);
	}

	private UserDetails map(UserEntity userEntity) {
		String roleName = userEntity.getRole().getRole().name();

		Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + roleName));

		return new AppUserDetails(userEntity.getUsername(), userEntity.getPassword(), authorities,
				userEntity.getEmail());
	}

}
