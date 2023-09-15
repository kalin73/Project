package com.softuni.registerform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	@GetMapping("/java")
	public String getJavaPage() {
		return "Java";
	}
}
