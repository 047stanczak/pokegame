package com.stanczak.pokegame.ui;

public class BattleUi {

    private final Console console;

    public BattleUi(Console console) {
        this.console = console;
    }

    public final void battle() {
        console.clearScreen();
        console.println("Batalha iniciada! (Funcionalidade em desenvolvimento)");
        console.println("Pressione Enter para voltar ao menu.");
        String line = console.readLine("> ").trim();
        if (line.isEmpty() || !line.isEmpty()) {
            return;
        }
    }
}
