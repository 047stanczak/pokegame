package com.stanczak.pokegame.model;

import java.util.List;

public class Move {
    private List<String> name;

    public List<String> getName() {
        return name;
    }


    public void setName(List<String> name) {
        this.name = name;
    }

    public Move(List<String> name) {
        this.name = name;
    }
}