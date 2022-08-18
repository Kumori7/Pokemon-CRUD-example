package com.ab.Reposistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ab.Entities.Pokemon;

@Repository
public interface PokemonReposistory extends JpaRepository<Pokemon, Integer> {

}
