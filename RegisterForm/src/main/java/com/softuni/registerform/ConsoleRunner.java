package com.softuni.registerform;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.softuni.registerform.service.InitService;

@Component
public class ConsoleRunner implements CommandLineRunner {
	private final InitService initService;

	public ConsoleRunner(InitService initService) {
		this.initService = initService; 
	}

	@Override
	public void run(String... args) throws Exception {
		initService.initRoles();
	}

}
