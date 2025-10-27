package com.stanczak.pokegame.util;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.stanczak.pokegame.model.ElementType;
import com.stanczak.pokegame.model.Moves;
import com.stanczak.pokegame.model.Pokemon;
import com.stanczak.pokegame.persistence.MovesLoader;

public class MoveSorter {
    private Pokemon pokemon;

    public MoveSorter(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public final List<Moves> sortMoves() {
        List<ElementType> types = pokemon.getType();
        List<Moves> moves = MovesLoader.movesList;

        List<Moves> movesFiltered = moves.stream()
            .filter(move -> types.contains(move.getType()))
            .collect(Collectors.toList());
            
        List<Moves> selectedMoves = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(movesFiltered.size());
            selectedMoves.add(movesFiltered.get(randomIndex));
        }

        return selectedMoves;
    }
}
