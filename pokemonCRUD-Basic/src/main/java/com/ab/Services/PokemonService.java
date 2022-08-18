package com.ab.Services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.Entities.Pokemon;
import com.ab.Reposistories.PokemonReposistory;

@Service
public class PokemonService {

	@Autowired
	private PokemonReposistory pokemonReposistory;

	public List<Pokemon> getAllPokemons() {
		return this.pokemonReposistory.findAll();
	}

	public Pokemon savePokemon(Pokemon pokemon) {

		return this.pokemonReposistory.save(pokemon);
	}

	public Pokemon updatePokemon(Pokemon pokemon) {

		Pokemon existingPokemon = pokemonReposistory.findById(pokemon.getId()).orElse(null);

		// once we found exisitingPokemon we update its variables
		existingPokemon.setPokemonName(pokemon.getPokemonName());
		existingPokemon.setLevel(pokemon.getLevel());
		existingPokemon.setGenerationNumber(pokemon.getGenerationNumber());

		return this.pokemonReposistory.save(existingPokemon);
	}

	public void deletePokemonById(int id) {

		this.pokemonReposistory.deleteById(id);
	}

	public List<Pokemon> sortByPokemonLevel() {
		List<Pokemon> pokemonList = this.pokemonReposistory.findAll();

		List<Pokemon> sortList = pokemonList.stream().sorted(Comparator.comparing(Pokemon::getLevel))
				.collect(Collectors.toList());

		return sortList;
	}

	public List<Pokemon> sortPokemonByGeneration() {
		List<Pokemon> pokemonList = this.pokemonReposistory.findAll();

		List<Pokemon> sortList = pokemonList.stream().sorted(Comparator.comparing(Pokemon::getGenerationNumber))
				.collect(Collectors.toList());

		return sortList;
	}

	public List<Pokemon> sortPokemonByGenerationAndName() {

		List<Pokemon> pokemonList = this.pokemonReposistory.findAll();

		List<Pokemon> soList = pokemonList.stream()
				.sorted(Comparator.comparing(Pokemon::getGenerationNumber).thenComparing(p -> p.getPokemonName()))
				.collect(Collectors.toList());

		return soList;

	}

} // end of class
