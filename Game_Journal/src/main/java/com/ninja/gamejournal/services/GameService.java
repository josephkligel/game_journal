package com.ninja.gamejournal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninja.gamejournal.models.Game;
import com.ninja.gamejournal.repositories.GameRepository;

@Service
public class GameService {
	private final GameRepository gameRepo;
	
	public GameService(GameRepository gameRepo) {
		this.gameRepo = gameRepo;
	}
	
	public Game createGame(Game game) {
		return gameRepo.save(game);
	}
	
	public Game updateGame(Game game) {
		return gameRepo.save(game);
	}
	
	public Game findGame(Long gameId) {
		Optional<Game> potentialGame = gameRepo.findById(gameId);
		if(potentialGame.isPresent()) {
			return potentialGame.get();
		}
		return null;
	}
	
	public List<Game> allGames(){
		return gameRepo.findAll();
	}
	
	public void deleteGame(Long gameId) {
		gameRepo.deleteById(gameId);
	}
}
