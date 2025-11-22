package com.stanczak.pokegame;

import com.stanczak.pokegame.controller.BattleController;
import com.stanczak.pokegame.controller.PokemonController;
import com.stanczak.pokegame.service.PokemonService;
import com.stanczak.pokegame.ui.Console;
import com.stanczak.pokegame.ui.MenuUi;

public class Main {
    public static void main(String[] args) {
        Console console = new Console(System.in, System.out);
        PokemonService pokemonService = new PokemonService();
        PokemonController pokemonController = new PokemonController(pokemonService);
        BattleController battleController = new BattleController(pokemonController);
        try {
           MenuUi menu = new MenuUi(console, battleController);
           menu.start();
        } finally {
            console.close();
        }
}

}