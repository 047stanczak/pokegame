package com.stanczak.pokegame.ui;

import com.stanczak.pokegame.model.Pokemon;
import com.stanczak.pokegame.service.PokemonService;

public class BattleUi {

    private final Console console;
    private final PokemonService pokemonService;

    public BattleUi(Console console, PokemonService pokemonService) {
        this.console = console;
        this.pokemonService = pokemonService;
    }

    public final void startBattleFlow() {
        console.clearScreen();
        console.println("Antes de começar a batalha, você precisa escolher seu pokemon e um oponente.");
        choosePokemon();

        console.clearScreen();
        console.println("A partir de agora, a batalha começará!");
        console.pause();
        //battle(null, null); // PARA IMPLEMENTAR: Passar os pokémons escolhidos
    }

    public final void choosePokemon() {
        console.println("Selecione um pokemon para lutar:");
        String pokemonId = console.readLine("> ").trim();
        console.println("Selecione um oponente:");
        String opponentPokemonId = console.readLine("> ").trim();
        Pokemon pokemon = pokemonService.filterPokemon(pokemonId);
        Pokemon opponentPokemon = pokemonService.filterPokemon(opponentPokemonId);
        pokemon.setMoves(pokemonService.sortMoves(pokemon));
        opponentPokemon.setMoves(pokemonService.sortMoves(opponentPokemon));
    }

    public final void battle(Pokemon pokemon, Pokemon opponentPokemon) {
        console.clearScreen();
        console.println(pokemon.getName() + " HP: " + pokemon.getHp() + " - " + opponentPokemon.getName() + " HP: " + opponentPokemon.getHp());
        console.println("");

        console.println("1 - Ataques");
        console.println("2 - Itens");
        console.println("3 - Fugir");
        String line = console.readLine("> ").trim();
        int option = Integer.parseInt(line);

        switch (option) {
            case 1:
                console.clearScreen();
                console.println("Escolha um ataque:");
                // PARA IMPLEMENTAR: Listar os ataques do Pokémon
                break;
            case 2:
                console.clearScreen();
                console.println("Itens não implementados ainda!");
                console.println("Pressione Enter para continuar...");
                console.readLine("> ").trim();
                battle(pokemon, opponentPokemon);
                break;
            case 3:
                console.println("Você fugiu da batalha!");
                return;
            default:
                console.println("Opção inválida!");
                break;
        }
    }
}
