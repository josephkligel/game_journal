package com.ninja.gamejournal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ninja.gamejournal.models.LoginUser;
import com.ninja.gamejournal.models.User;
import com.ninja.gamejournal.services.GameService;
import com.ninja.gamejournal.services.JournalEntryService;
import com.ninja.gamejournal.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	public UserService userService;
	
	@Autowired
	public GameService gameService;
	
	@Autowired
	public JournalEntryService journalEntryService;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		// Attempt to register a new user
		userService.register(newUser, result);
		// Check for errors and pass in newLogin object if error is present and index page has to be returned
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		// Else if no errors save user to a session and go to user home
		session.setAttribute("user", newUser);
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		// Calling login method from UserService
		// Assign return object to a new user
		User user = userService.login(newLogin, result);
		// Check for errors
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		// If no errors save user object in session and redirect to home page
		session.setAttribute("user", user);
		return "redirect:/home";
	}
	
	// Logout and destroy session
		
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// User homepage
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			model.addAttribute("games", gameService.allGames());
			model.addAttribute("journalEntries", journalEntryService.allJournalEntries());
			return "home.jsp";
		}
		return "redirect:/";
	}
	
}
