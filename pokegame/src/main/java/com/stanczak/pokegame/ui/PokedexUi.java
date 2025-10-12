package com.stanczak.pokegame.ui;

import com.stanczak.pokegame.model.Pokemon;
import com.stanczak.pokegame.persistence.DataLoader;
import com.stanczak.pokegame.persistence.MessageLoader;
import com.stanczak.pokegame.util.FilterPokemonById;

public class PokedexUi {

    private final Console console;

    public PokedexUi(Console console) {
        this.console = console;
    }

    public final void pokedex() {
        var messages = MessageLoader.getMessages();
        var pokedex = messages.getPokedex();
        var menu = messages.getMenu();
        var pokemonList = DataLoader.pokemonList;

        console.clearScreen();
        console.println(pokedex.getTitle());
        console.println(menu.getTitle());
        console.println(pokedex.getOption_list());
        console.println(pokedex.getOption_search());
        console.println(menu.getOption_back());

        String line = console.readLine("> ").trim();
        int option = Integer.parseInt(line);

        switch (option) {
            case 1:
                console.clearScreen();
                pokemonList.forEach(pokemon -> 
                console.println(pokedex.getName() + pokemon.getName() + " - " + pokedex.getId() + pokemon.getId()));
                console.println(pokedex.getPress_enter());
                line = console.readLine("> ").trim();
                if (line.isEmpty() || !line.isEmpty()) {
                    return;
                }
            case 2:
                console.clearScreen();
                console.println(pokedex.getEnter_id());
                String line2 = console.readLine("> ").trim();
                int id = Integer.parseInt(line2);
                console.clearScreen();
                FilterPokemonById filter = new FilterPokemonById(id);
                Pokemon pokemon = filter.filter();

                if (pokemon == null) {
                    console.println("Pokémon não encontrado!");
                } else {
                    console.println(pokedex.getName() + pokemon.getName());
                    console.println(pokedex.getHp() + pokemon.getHp());
                    console.println(pokedex.getAttack() + pokemon.getStatus().getAttack());
                    console.println(pokedex.getDefense() + pokemon.getStatus().getDefense());
                    console.println(pokedex.getSpeed() + pokemon.getStatus().getSpeed());
                    console.println(pokedex.getModifiers() + pokemon.getModifiers().name());
                    console.println(pokedex.getType() + pokemon.getType());
                    console.println(pokedex.getMoves() + String.join(", ", pokemon.getMoves()));
                }

                console.println(pokedex.getPress_enter());
                console.readLine("> ");
                console.clearScreen();

                return;
            case 3:
                System.out.println("Voltando...");
                return;
        
            default:
                break;
        }
    }
}
