package com.stanczak.pokegame.ui;

import com.stanczak.pokegame.persistence.MessageLoader;

public class StartPageUI {

    private final Console console;

    public StartPageUI(Console console) {
        this.console = console;
    }

    public final void start() {
        boolean inMenu = true;
        var messages = MessageLoader.getMessages();
        var menu = messages.getMenu();

        while(inMenu){
            console.clearScreen();
            console.println(menu.getMenu_options());
            console.println(menu.getOption_battle());
            console.println(menu.getOption_pokedex());
            console.println(menu.getOption_back());

            String line = console.readLine("> ").trim();
            int option = Integer.parseInt(line);

            switch (option) {
                case 1:
                    console.clearScreen();
                    console.println("Batalha em desenvolvimento...");
                    break;
                case 2:
                    PokedexUi pokedexUi = new PokedexUi(console);
                    pokedexUi.pokedex();
                    break;
                case 3:
                    console.clearScreen();
                    inMenu = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}