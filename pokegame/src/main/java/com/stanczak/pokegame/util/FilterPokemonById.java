package com.stanczak.pokegame.util;

import com.stanczak.pokegame.model.Pokemon;
import com.stanczak.pokegame.persistence.DataLoader;

public class FilterPokemonById {
    private int id;

    public FilterPokemonById(int id) {
        this.id = id;
    }

    public final Pokemon filter() {

        return DataLoader.pokemonList.stream()
            .filter(pokemon -> pokemon.getId() == id)
            .findFirst()
            .orElse(null);
    }

}