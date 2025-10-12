package com.stanczak.pokegame.ui;

import com.stanczak.pokegame.persistence.MessageLoader;

public class MenuUi {

    private final Console console;

    public MenuUi(Console console) {
        this.console = console;
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
                    StartPageUI startPage = new StartPageUI(console);
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
