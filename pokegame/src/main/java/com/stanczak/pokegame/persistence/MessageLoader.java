package com.stanczak.pokegame.persistence;

import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stanczak.pokegame.model.messages.Messages;

public final class MessageLoader {

    private static final Messages MESSAGES_OBJ;
    static {
        try (InputStream in = Messages.class.getResourceAsStream("/messages/pt-BR/messages.json")) {
            if(in == null){throw new IllegalStateException("Arquivo não encontrado");}
            ObjectMapper mapper = new ObjectMapper();
            MESSAGES_OBJ = mapper.readValue(in, Messages.class);
        } catch (IOException e) {
            throw new IllegalStateException("Erro ao carregar o arquivo de mensagens", e);
        }
    }
        public static Messages getMessages() {
            return MESSAGES_OBJ;
        }
}
