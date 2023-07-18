package com.ninja.gamejournal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ninja.gamejournal.models.JournalEntry;
import com.ninja.gamejournal.services.GameService;
import com.ninja.gamejournal.services.JournalEntryService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class JournalEntryController {
	@Autowired
	private JournalEntryService journalEntryService;
	
	@Autowired
	private GameService gameService;
	
	public String checkAccess(HttpSession session, Model model, String webpage) {
		// If user is logged send user to requested webpage
		if(session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			model.addAttribute("games", gameService.allGames());
			model.addAttribute("journalEntries", journalEntryService.allJournalEntries());
			return webpage;
		}
		// If user is not logged in send user back to index page (login page)
		return "redirect:/";
	}
	
	@GetMapping("/journal/add")
	public String add(@ModelAttribute("journalEntry") JournalEntry journalEntry, HttpSession session, Model model) {
		model.addAttribute("games", gameService.allGames());
		return checkAccess(session, model, "journalEntryAdd.jsp");
	}
	
	@PostMapping("/journal/create")
	public String create(@Valid @ModelAttribute("journalEntry") JournalEntry journalEntry, BindingResult result) {
		if(result.hasErrors()) {
			return "journalEntryAdd.jsp";
		}
		journalEntryService.createJournalEntry(journalEntry);
		return "redirect:/home";
	}
	
	@GetMapping("/journal/{journalEntryId}")
	public String show(@PathVariable("journalEntryId") Long journalEntryId, Model model, HttpSession session) {
		model.addAttribute("journalEntry", journalEntryService.findJournalEntry(journalEntryId));
		model.addAttribute("user", session.getAttribute("user"));
		return checkAccess(session, model, "journalEntryShow.jsp");
	}
	
	@GetMapping("/journal/edit/{journalEntryId}")
	public String edit(@PathVariable("journalEntryId") Long journalEntryId, HttpSession session, Model model) {
		model.addAttribute("journalEntry", journalEntryService.findJournalEntry(journalEntryId));
		model.addAttribute("games", gameService.allGames());
		return checkAccess(session, model, "journalEntryEdit.jsp");
	}
	
	@PutMapping("/journal/update")
	public String update(@Valid @ModelAttribute("journalEntry") JournalEntry journalEntry, BindingResult result) {
		if(result.hasErrors()) {
			return "journalEntryEdit.jsp";
		}
		journalEntryService.updateJournalEntry(journalEntry);
		return "redirect:/home";
	}
}
