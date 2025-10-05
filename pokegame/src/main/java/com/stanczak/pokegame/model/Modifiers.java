package com.stanczak.pokegame.model;

public enum Modifiers {
    NONE("None");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Modifiers(String name) {
        this.name = name;
    }
}
