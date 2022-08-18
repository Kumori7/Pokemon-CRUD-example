package com.ab.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String pokemonName;
	int level;
	int generationNumber;

	public Pokemon() {
		super();
	}

	public Pokemon(String pokemonName, int level, int generationNumber) {
		super();
		this.pokemonName = pokemonName;
		this.level = level;
		this.generationNumber = generationNumber;
	}

	public Pokemon(int id, String pokemonName, int level, int generationNumber) {
		super();
		this.id = id;
		this.pokemonName = pokemonName;
		this.level = level;
		this.generationNumber = generationNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGenerationNumber() {
		return generationNumber;
	}

	public void setGenerationNumber(int generationNumber) {
		this.generationNumber = generationNumber;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", pokemonName=" + pokemonName + ", level=" + level + ", generationNumber="
				+ generationNumber + "]";
	}

} // end of class
