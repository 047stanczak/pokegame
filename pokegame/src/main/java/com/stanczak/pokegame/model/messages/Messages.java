package com.stanczak.pokegame.model.messages;

public class Messages {
    private Menu menu;
    private Pokedex pokedex;

    public Menu getMenu() {
        return menu;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }
}
