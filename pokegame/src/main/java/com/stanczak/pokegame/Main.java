package com.stanczak.pokegame;

import com.stanczak.pokegame.ui.Console;
import com.stanczak.pokegame.ui.MenuUi;

public class Main {
    public static void main(String[] args) {
        Console console = new Console(System.in, System.out);
        try {
           MenuUi menu = new MenuUi(console);
           menu.start();
        } finally {
            console.close();
        }
}

}