package com.softuni.registerform.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softuni.registerform.domain.dto.AppUserDetails;
import com.softuni.registerform.domain.dto.UserChangePasswordDto;
import com.softuni.registerform.domain.dto.UserRegisterForm;
import com.softuni.registerform.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {
	private static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
	private final UserService userService;
	private final UserChangePasswordDto user;

	public AuthController(UserService userService, UserChangePasswordDto user) {
		this.userService = userService;
		this.user = user;

	}

	@GetMapping("/register")
	public ModelAndView getRegister(ModelAndView modelAndView, @ModelAttribute UserRegisterForm userRegisterForm) {
		modelAndView.setViewName("register");
		// modelAndView.addObject("userRegisterForm", new UserRegisterForm());

		return modelAndView;
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute UserRegisterForm userRegisterForm, RedirectAttributes redirectAttributes,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("userRegisterForm", userRegisterForm)
					.addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);
			return "redirect:/register";
		}

		this.userService.registerUser(userRegisterForm);

		redirectAttributes.addFlashAttribute("username", userRegisterForm.getUsername());

		return "redirect:/login";
	}

	@GetMapping("/login")
	public ModelAndView getLogin(ModelAndView modelAndView) {
		modelAndView.setViewName("login");

		return modelAndView;
	}

	@GetMapping("/forgotPassword")
	public ModelAndView forgotPassword(ModelAndView modelAndView) {
		modelAndView.setViewName("forgotPassword");

		return modelAndView;
	}

	@GetMapping("/newPassword")
	public String NewPasswordPage() {
		return "changePassword";
	}

	@PostMapping("/newPassword")
	public String createNewPassword(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {
			this.userService.changePassword(confirmPassword, user.getEmail());
			user.setEmail(null);

			return "redirect:/login";
		}

		return "changePassword";
	}

	@PostMapping("/forgotPassword")
	public String forgotPassword(String email, RedirectAttributes redirectAttributes) {
		if (userService.checkEmail(email)) {
			user.setEmail(email);

			return "redirect:/newPassword";
		}
		redirectAttributes.addFlashAttribute("isPresent", false);

		return "redirect:/forgotPassword";
	}

	@GetMapping("/success")
	public ModelAndView successLogin(@AuthenticationPrincipal AppUserDetails userDetails, ModelAndView modelAndView) {
		modelAndView.setViewName("First Page");
		modelAndView.addObject("email", userDetails.getEmail());

		return modelAndView;
	}

	@PostMapping("/login-error")
	public String onFailedLogin(RedirectAttributes redirectAttributes, String username) {
		redirectAttributes.addFlashAttribute("username", username);
		redirectAttributes.addFlashAttribute("bad_credentials", true);

		return "redirect:/login";
	}
}
