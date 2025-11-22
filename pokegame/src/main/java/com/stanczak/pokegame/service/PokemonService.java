package com.stanczak.pokegame.service;

import java.util.List;

import com.stanczak.pokegame.model.Moves;
import com.stanczak.pokegame.model.Pokemon;
import com.stanczak.pokegame.util.FilterPokemonById;
import com.stanczak.pokegame.util.MoveSorter;

public class PokemonService {

    public Pokemon filterPokemonById(String pokemonId) {
        try {
            FilterPokemonById pokemonFilter = new FilterPokemonById(Integer.parseInt(pokemonId));
            Pokemon pokemon = pokemonFilter.filter();
            return pokemon;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Moves> sortMoves(Pokemon pokemon) {
        MoveSorter moveSorter = new MoveSorter(pokemon);
        List<Moves> moves = moveSorter.sortMoves();
        return moves;
    }
}
