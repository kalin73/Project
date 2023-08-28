package com.softuni.registerform.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.softuni.registerform.domain.dto.AuthenticatedUser;
import com.softuni.registerform.domain.enums.Roles;
import com.softuni.registerform.repository.UserRepository;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain secFilter(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeHttpRequests(requestMatcher -> requestMatcher
						.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
						.requestMatchers("/login", "/", "/login-error", "/register", "/forgotPassword", "/newPassword").permitAll()
						.requestMatchers("/success").authenticated()
						.requestMatchers("/bearPage").hasRole(Roles.TEACHER.name()))
				.formLogin(login -> login.loginPage("/login").usernameParameter("username")
						.passwordParameter("password").defaultSuccessUrl("/success").failureForwardUrl("/login-error"))
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true))
				.rememberMe(me -> me.key("someUniqueKey").tokenValiditySeconds(604800));

		return httpSecurity.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService userDetails(UserRepository userRepository) {
		return new AuthenticatedUser(userRepository);
	}
}
