package com.ab.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.Entities.Pokemon;
import com.ab.Services.PokemonService;

@RestController
public class PokemonController {

	// http://localhost:8080/......

	@Autowired
	private PokemonService pokemonService;

	// GET request
	// http://localhost:8080/getPokemon
	@GetMapping("/getPokemon")
	public List<Pokemon> getAllPokemons() {
		return this.pokemonService.getAllPokemons();
	}

	// dont forget request body or wont save to database
	// POST request
	// http://localhost:8080/savePokemon
	@PostMapping("/savePokemon")
	public Pokemon savePokemon(@RequestBody Pokemon pokemon) {

		return this.pokemonService.savePokemon(pokemon);
	}

	// DELETE request
	// http://localhost:8080/delete/ (place id number here)
	@DeleteMapping("/delete/{id}")
	public void deletePokemon(@PathVariable("id") int id) {

		this.pokemonService.deletePokemonById(id);
	}

	// PUT request
	// http://localhost:8080/update
	// put all variables in request body to update by Id
	@PutMapping("/update")
	public Pokemon updatePokemon(@RequestBody Pokemon pokemon) {

		return this.pokemonService.updatePokemon(pokemon);
	}

	// GET request
	// http://localhost:8080/sort-by-level
	@GetMapping("/sort-by-level")
	public List<Pokemon> sortByPokemonLevel() {

		return this.pokemonService.sortByPokemonLevel();
	}

	// GET request
	// http://localhost:8080/sort-by-generation
	@GetMapping("/sort-by-generation")
	public List<Pokemon> sortPokemonByGeneration() {

		return this.pokemonService.sortPokemonByGeneration();
	}

	// GET request
	// http://localhost:8080/sort-by-generation-and-name
	@GetMapping("/sort-by-generation-and-name")
	public List<Pokemon> sortPokemonByGenerationAndName() {

		return this.pokemonService.sortPokemonByGenerationAndName();
	}

} // end of class
