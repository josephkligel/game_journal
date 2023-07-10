package com.ninja.gamejournal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninja.gamejournal.models.JournalEntry;

@Repository
public interface JournalEntryRepository extends CrudRepository<JournalEntry, Long> {
	Optional<JournalEntry> findById(Long journalEntryId);
	
	List<JournalEntry> findByGameId(Long gameId);
	
	List<JournalEntry> findByUserId(Long userId);
	
	List<JournalEntry> findAll();
}
