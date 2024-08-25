package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	private static GameService service = null; // Ensures GameService is already instantiated
	
	private GameService() { // Default constructor
	}

	// Allows for the Singleton to work
	public static GameService getInstance() {
		if (service == null) { // Ensures that GameService exists
			service = new GameService ();
			System.out.println("New Game Service created.");
		}
		else { // Outputs this message if GameService already exists
			System.out.println("Game Service already instantiated");
		}
		return service;
	}


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Iterator of Game type
		Iterator<Game> gamesIterator = games.iterator();
		
		while (gamesIterator.hasNext()) { // Searches through list of games
			Game gameInstance = gamesIterator.next(); // Local variable to get next list item
			if (gameInstance.getName().equalsIgnoreCase(name)) { // Searches for game with same name
				return gameInstance; // If same name found, returns that game
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// Iterator instance
		Iterator <Game> gamesIterator = games.iterator();
		
		while (gamesIterator.hasNext()) { // Searches through list of games
			Game gameInstance = gamesIterator.next(); // Local variable to get next list item
			if (gameInstance.getId() == id) { // Searches for game with same name
				return gameInstance; // If same name found, returns that game
			}
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Iterator instance
		Iterator<Game> gamesIterator = games.iterator();
		
		while (gamesIterator.hasNext()) { // Searches through list of games
			Game gameInstance = gamesIterator.next(); // Local variable to get next list item
			if (gameInstance.getName().equalsIgnoreCase(name)) { // Searches for games with the same name
				game = gameInstance; // Sets game to the game with the same name
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
