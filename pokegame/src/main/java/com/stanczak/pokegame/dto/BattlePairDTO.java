package com.stanczak.pokegame.dto;

import com.stanczak.pokegame.model.Pokemon;

public class BattlePairDTO {
    private final Pokemon player;
    private final Pokemon opponent;

    public BattlePairDTO(Pokemon player, Pokemon opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public Pokemon getPlayer() {
        return player;
    }

    public Pokemon getOpponent() {
        return opponent;
    }
}
