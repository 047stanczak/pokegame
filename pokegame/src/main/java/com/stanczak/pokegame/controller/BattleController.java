package com.stanczak.pokegame.controller;

import java.util.Optional;

import com.stanczak.pokegame.dto.BattlePairDTO;

public class BattleController {

    private final PokemonController pokemonController;

    public BattleController(PokemonController pokemonController){
        this.pokemonController = pokemonController;
    }

    public final Optional<BattlePairDTO> choosePokemon(String playerPokemonId, String opponentPokemonId){
        try {
            Optional<BattlePairDTO> pair = pokemonController.choosePokemon(playerPokemonId, opponentPokemonId);
            return pair;
        } catch (NullPointerException e) {
            Optional<BattlePairDTO> pair = Optional.empty();
            return pair;
        }
    }
}
