package com.stanczak.pokegame.model;

public enum Category {
    PHYSICAL("Physical"), SPECIAL("Special"), STATUS("Status");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Category(String name) {
        this.name = name;
    }
}
