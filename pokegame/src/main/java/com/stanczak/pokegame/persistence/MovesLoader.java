package com.stanczak.pokegame.persistence;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stanczak.pokegame.model.Moves;

public class MovesLoader {
    public static List<Moves> movesList;
    static {
        try {
            InputStream inputStream = Moves.class.getClassLoader().getResourceAsStream("moves.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Moves> moves = objectMapper.readValue(inputStream, 
            new TypeReference<List<Moves>>() {});
            inputStream.close();
            movesList = moves;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
