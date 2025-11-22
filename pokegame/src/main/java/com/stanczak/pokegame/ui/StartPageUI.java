package com.stanczak.pokegame.ui;

import com.stanczak.pokegame.controller.BattleController;
import com.stanczak.pokegame.persistence.MessageLoader;

public class StartPageUI {

    private final Console console;
    private final BattleController battleController;


    public StartPageUI(Console console, BattleController battleController) {
        this.console = console;
        this.battleController = battleController;
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
                    BattleUi battleUi = new BattleUi(console, battleController);
                    battleUi.startBattleFlow();
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
                    console.println(menu.getOption_invalid());
                    break;
            }
        }
    }
}