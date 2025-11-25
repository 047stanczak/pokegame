package com.stanczak.pokegame.ui;

import java.util.Optional;

import com.stanczak.pokegame.controller.BattleController;
import com.stanczak.pokegame.dto.BattlePairDTO;
import com.stanczak.pokegame.model.Pokemon;
import com.stanczak.pokegame.model.messages.Battle;
import com.stanczak.pokegame.persistence.MessageLoader;
public class BattleUi {

    private final Console console;
    private final BattleController battleController;

    public BattleUi(Console console, BattleController battleController) {
        this.console = console;
        this.battleController = battleController;
    }

    public Battle battleMessage() {
        var messages = MessageLoader.getMessages();
        var battle = messages.getBattle();
        return battle;
    }

    public final void startBattleFlow() { 
        console.clearScreen();
        console.println(battleMessage().getBattle_start());
        
        choosePokemon();
    }

    public final void choosePokemon() {
        console.println(battleMessage().getChoose_your_pokemon());
        String playerPokemonId = console.readLine("> ").trim();
        console.println(battleMessage().getChoose_opponent_pokemon());
        String opponentPokemonId = console.readLine("> ").trim();
        Optional<BattlePairDTO> pair = battleController.choosePokemon(playerPokemonId, opponentPokemonId);
        if (pair.isPresent()) {
            showBattleStatus(pair.get().getPlayer(), pair.get().getOpponent());
        } else {
            choosePokemonError();
        }
    }

    public final void choosePokemonError() {
        console.clearScreen();
        console.println("Entrada inválida. Deseja tentar novamente? (s/n)");
        while (true) {
            String resp = console.readLine("> ").trim().toLowerCase();
            if (resp.equals("s") || resp.equals("sim")) {
                choosePokemon();
                return;
            } else if (resp.equals("n") || resp.equals("nao") || resp.equals("não")) {
                console.println("Operação cancelada.");
                console.pause();
                return;
            } else {
                console.println("Resposta inválida. Digite 's' para sim ou 'n' para não.");
            }
        }
    }

    public final void showBattleStatus (Pokemon player, Pokemon opponentPokemon) {
        console.clearScreen();
        console.println(battleMessage().getStatus()
        .replace("{pokemon}", player.getName())
        .replace("{hp}", String.valueOf(player.getHp()))
        .replace("{opponent}", opponentPokemon.getName())
        .replace("{opponent_hp}", String.valueOf(opponentPokemon.getHp()))
        );
        console.pause();

        
    }
}
