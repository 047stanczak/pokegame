package com.stanczak.pokegame.model;

import java.util.List;

public class Pokemon {
    private int id;
    private String name;
    private int hp;
    private Status status;
    private Modifiers modifiers;  
    private List<ElementType> type;
    private List<String> moves;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Modifiers getModifiers() {
        return modifiers;
    }
    public void setModifiers(Modifiers modifiers) {
        this.modifiers = modifiers;
    }
    public List<ElementType> getType() {
        return type;
    }
    public void setType(List<ElementType> type) {
        this.type = type;
    }
    public List<String> getMoves() {
        return moves;
    }
    public void setMoves(List<String> moves) {
        this.moves = moves;
    }
}