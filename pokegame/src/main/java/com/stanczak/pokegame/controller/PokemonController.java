package com.stanczak.pokegame.controller;

import java.util.Optional;

import com.stanczak.pokegame.dto.BattlePairDTO;
import com.stanczak.pokegame.model.Pokemon;
import com.stanczak.pokegame.service.PokemonService;

public class PokemonController {

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    public Optional<BattlePairDTO> choosePokemon(String pokemonId, String opponentId) {
        Pokemon player = pokemonService.filterPokemonById(pokemonId);
        player.setMoves(pokemonService.sortMoves(player));
        Pokemon opponentPokemon = pokemonService.filterPokemonById(opponentId);
        opponentPokemon.setMoves(pokemonService.sortMoves(opponentPokemon));
        
        return Optional.of(new BattlePairDTO(player, opponentPokemon));
    }

}
