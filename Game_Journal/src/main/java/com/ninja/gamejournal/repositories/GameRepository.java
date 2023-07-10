package com.ninja.gamejournal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninja.gamejournal.models.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
	
	Optional<Game> findById(Long id);
	
	List<Game> findAll();
}
