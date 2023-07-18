package com.ninja.gamejournal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ninja.gamejournal.models.Game;
import com.ninja.gamejournal.services.GameService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class GameController {
	@Autowired
	private GameService gameService;
	
	public String checkAccess(HttpSession session, Model model, String webpage) {
		// If user is logged send user to requested webpage
		if(session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			model.addAttribute("games", gameService.allGames());
			return webpage;
		}
		// If user is not logged in send user back to index page (login page)
		return "redirect:/";
	}
	
	@GetMapping("/games/add")
	public String add(@ModelAttribute("game") Game game, HttpSession session, Model model) {
		return checkAccess(session, model, "gameAdd.jsp");
	}
	
	@PostMapping("/games/create")
	public String create(
			@Valid @ModelAttribute("game") Game game,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "gameAdd.jsp";
		}
		gameService.createGame(game);
		return "redirect:/home";
	}
	
	@GetMapping("/games/{gameId}")
	public String show(@PathVariable("gameId") Long gameId, HttpSession session, Model model) {
		model.addAttribute("game", gameService.findGame(gameId));
		return checkAccess(session, model, "gameShow.jsp");
	}
	
	@GetMapping("/games/edit/{gameId}")
	public String edit(@PathVariable("gameId") Long gameId, HttpSession session, Model model) {
		model.addAttribute("game", gameService.findGame(gameId));
		return checkAccess(session, model, "gameEdit.jsp");
	}
	
	@PutMapping("/games/update")
	public String update(@Valid @ModelAttribute("game") Game game, BindingResult result) {
		if(result.hasErrors()) {
			return "gameEdit.jsp";
		}
		gameService.updateGame(game);
		return "redirect:/home";
	}
	
	@DeleteMapping("/games/delete/{gameId}")
	public String delete(@PathVariable("gameId") Long gameId) {
		gameService.deleteGame(gameId);
		return "redirect:/home";
	}
}
