package com.stanczak.pokegame.ui;

import com.stanczak.pokegame.persistence.MessageLoader;
import com.stanczak.pokegame.service.PokemonService;

public class MenuUi {

    private final Console console;
    private final PokemonService pokemonService;

    public MenuUi(Console console, PokemonService pokemonService) {
        this.console = console;
        this.pokemonService = pokemonService;
    }

    public final void start() {
        boolean running = true;
        var messages = MessageLoader.getMessages();
        var menu = messages.getMenu();

        while(running){
            console.clearScreen();
            console.println(menu.getTitle());
            console.println(menu.getOption_play());
            console.println(menu.getOption_exit());

            String line = console.readLine("> ").trim();
            int option = Integer.parseInt(line);

            switch (option) {
                case 1:
                    StartPageUI startPage = new StartPageUI(console, pokemonService);
                    startPage.start();
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    console.println(menu.getOption_invalid());
                    break;
            }
        }
    }
}
