package com.stanczak.pokegame.persistence;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stanczak.pokegame.model.Pokemon;

public class PokemonLoader {
    public static List<Pokemon> pokemonList;
    static {
        try {
            InputStream inputStream = Pokemon.class.getClassLoader().getResourceAsStream("pokemon.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Pokemon> pokemons = objectMapper.readValue(inputStream, 
            new TypeReference<List<Pokemon>>() {});
            inputStream.close();
            pokemonList = pokemons;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}