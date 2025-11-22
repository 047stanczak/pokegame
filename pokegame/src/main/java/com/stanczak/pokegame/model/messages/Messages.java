package com.stanczak.pokegame.model.messages;

public class Messages {
    private Menu menu;
    private Pokedex pokedex;
    private Battle battle;

    public Menu getMenu() {
        return menu;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }
}
