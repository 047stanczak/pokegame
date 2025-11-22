package com.stanczak.pokegame.model.messages;

public class Battle {
    private String title_choose_pokemon;
    private String choose_pokemon;
    private String choose_your_pokemon;
    private String choose_opponent_pokemon;
    private String invalid_pokemon_choice;
    private String battle_start;
    private String confrontation;
    private String status;

    private OpponentMessages opponent;
    private PokemonMessages pokemon;

    public String getTitle_choose_pokemon() {
        return title_choose_pokemon;
    }
    public String getChoose_pokemon() {
        return choose_pokemon;
    }
    public String getChoose_your_pokemon() {
        return choose_your_pokemon;
    }
    public String getChoose_opponent_pokemon() {
        return choose_opponent_pokemon;
    }
    public String getInvalid_pokemon_choice() {
        return invalid_pokemon_choice;
    }
    public String getBattle_start() {
        return battle_start;
    }
    public String getConfrontation() {
        return confrontation;
    }
    public String getStatus() {
        return status;
    }
    public OpponentMessages getOpponent() {
        return opponent;
    }
    public PokemonMessages getPokemon(){
        return pokemon;
    }
    public void setOpponent(OpponentMessages opponent) {
        this.opponent = opponent;
    }
    public void setPokemon(PokemonMessages pokemon) {
        this.pokemon = pokemon;
    }
}


