package com.stanczak.pokegame.ui;

import com.stanczak.pokegame.model.Pokemon;
import com.stanczak.pokegame.persistence.PokemonLoader;
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
        var pokemonList = PokemonLoader.pokemonList;

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
                console.pause();
                return;
            case 2:
                console.clearScreen();
                console.println(pokedex.getEnter_id());
                String line2 = console.readLine("> ").trim();
                int id = Integer.parseInt(line2);
                console.clearScreen();
                FilterPokemonById filter = new FilterPokemonById(id);
                Pokemon pokemon = filter.filter();

                if (pokemon == null) {
                    console.println(pokedex.getPokemon_not_found());
                } else {
                    console.println(pokedex.getName() + pokemon.getName());
                    console.println(pokedex.getHp() + pokemon.getHp());
                    console.println(pokedex.getAttack() + pokemon.getStatus().getAttack());
                    console.println(pokedex.getDefense() + pokemon.getStatus().getDefense());
                    console.println(pokedex.getSpeed() + pokemon.getStatus().getSpeed());
                    console.println(pokedex.getSp_attack() + pokemon.getStatus().getSp_attack());
                    console.println(pokedex.getSp_defense() + pokemon.getStatus().getSp_defense());
                    console.println(pokedex.getModifiers() + pokemon.getModifiers().name());
                    console.println(pokedex.getType() + pokemon.getType());
                }

                console.pause();
                console.clearScreen();

                return;
            case 3:
                console.println(pokedex.getBack());
                return;
        
            default:
                break;
        }
    }
}
