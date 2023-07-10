package com.ninja.gamejournal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninja.gamejournal.models.JournalEntry;
import com.ninja.gamejournal.repositories.JournalEntryRepository;

@Service
public class JournalEntryService {
	private final JournalEntryRepository journalEntryRepo;
	
	public JournalEntryService(JournalEntryRepository journalEntryRepo) {
		this.journalEntryRepo = journalEntryRepo;
	}
	
	public JournalEntry createJournalEntry(JournalEntry journalEntry) {
		return journalEntryRepo.save(journalEntry);
	}
	
	public JournalEntry updateJournalEntry(JournalEntry journalEntry) {
		return journalEntryRepo.save(journalEntry);
	}
	
	public JournalEntry findJournalEntry(Long entryId) {
		Optional<JournalEntry> potentialEntry = journalEntryRepo.findById(entryId);
		if(potentialEntry.isPresent()) {
			return potentialEntry.get();
		}
		return null;
	}
	
	public List<JournalEntry> findByGameId(Long gameId){
		return journalEntryRepo.findByGameId(gameId);
	}
	
	public List<JournalEntry> findByUserId(Long userId){
		return journalEntryRepo.findByUserId(userId);
	}
	
	public List<JournalEntry> allJournalEntries(){
		return journalEntryRepo.findAll();
	}
	
	public void deleteJournalEntry(Long journalEntryId) {
		journalEntryRepo.deleteById(journalEntryId);
	}
	
	
}
