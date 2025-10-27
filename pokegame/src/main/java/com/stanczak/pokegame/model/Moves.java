package com.stanczak.pokegame.model;

public class Moves {
    private String name;
    private int power;
    private int accuracy;
    private int pp;
    private Category category;
    private ElementType type;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    public int getPp() {
        return pp;
    }
    public void setPp(int pp) {
        this.pp = pp;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public ElementType getType() {
        return type;
    }
    public void setType(ElementType type) {
        this.type = type;
    }
}