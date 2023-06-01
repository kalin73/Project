package com.softuni.registerform.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.softuni.registerform.domain.dto.UserChangePasswordDto;

@Configuration
public class AppConfiguration {
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	UserChangePasswordDto userChangePassword() {
		return new UserChangePasswordDto();
	}
}
