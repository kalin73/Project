package com.softuni.registerform.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softuni.registerform.domain.dto.AppUserDetails;
import com.softuni.registerform.domain.dto.UserRegisterForm;
import com.softuni.registerform.service.UserService;

@Controller
public class HomeController {
	private final UserService userService;

	public HomeController(UserService userService) {
		this.userService = userService;

	}

	@GetMapping("/register")
	public String getRegister(UserRegisterForm userRegisterForm) {
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute UserRegisterForm userRegisterForm, RedirectAttributes redirectAttributes) {
		this.userService.registerUser(userRegisterForm);

		redirectAttributes.addFlashAttribute("username", userRegisterForm.getUsername());

		return "redirect:/login";
	}

	@GetMapping("/login")
	public ModelAndView getLogin(ModelAndView modelAndView) {
		modelAndView.setViewName("login");

		return modelAndView;
	}

	@GetMapping("/")
	public String home() {
		return "First Page";
	}

	@GetMapping("/bearPage")
	public String goToBearPage() {
		return "Wiki Page";
	}

	@GetMapping("/success")
	public ModelAndView successLogin(@AuthenticationPrincipal AppUserDetails userDetails, ModelAndView modelAndView) {
		modelAndView.setViewName("First Page");
		modelAndView.addObject("email", userDetails.getEmail());

		return modelAndView;
	}

	@PostMapping("/login-error")
	public String onFailedLogin(RedirectAttributes redirectAttributes, @ModelAttribute("username") String username) {
		redirectAttributes.addFlashAttribute("username", username);
		redirectAttributes.addFlashAttribute("bad_credentials", true);

		return "redirect:/login";
	}
//
//	@PostMapping("/login")
//	public void login(UserEntity loginUser) {
//		if (this.userRepository.findAllByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword())
//				.orElse(null) == null) {
//			System.out.println("Wrong username/password");
//		} else {
//			System.out.println("Success");
//		}
//	}

}
