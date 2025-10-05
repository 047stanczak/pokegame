package com.stanczak.pokegame.ui;

import java.util.Scanner;

import com.stanczak.pokegame.persistence.DataLoader;
import com.stanczak.pokegame.util.ClearTerminal;

public class ConsoleUI {
    public void start(Scanner scanner) {
        boolean inMenu = true;

        while(inMenu){
            System.out.println("Menu de opções");
            System.out.println("Por favor, selecione uma opção:");
            System.out.println("1 - Batalha");
            System.out.println("2 - Pokedex");
            System.out.println("3 - Voltar");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    ClearTerminal.clearTerminal();
                    battle(scanner);
                    break;
                case 2:
                    ClearTerminal.clearTerminal();
                    pokedex(scanner);
                    break;
                case 3:
                    System.out.println("Voltando...");
                    ClearTerminal.clearTerminal();
                    inMenu = false;
                    return;
            
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            }
        }

    public void battle(Scanner scanner) {
        System.out.println("Batalha...");
    }

    public void pokedex(Scanner scanner) {
        System.out.println("Pokedex...");
        System.out.println("Selecione uma opção");
        System.out.println("1 - Listar todos os Pokemons");
        System.out.println("2 - Buscar por id do Pokemon (Busca avançada)");
        System.out.println("3 - Voltar");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                DataLoader.pokemonList.forEach(pokemon -> System.out.println("Nome: " + pokemon.getName() + " - ID: " + pokemon.getId()));
                break;
            case 2:
                System.out.println("Digite o ID do Pokemon:");
                int id = scanner.nextInt();
                DataLoader.pokemonList.stream()
                        .filter(pokemon -> pokemon.getId() == id)
                        .findFirst()
                        .ifPresentOrElse(
                                pokemon -> System.out.println(pokemon),
                                () -> System.out.println("Pokemon não encontrado.")
                        );
                return;
            case 3:
                System.out.println("Voltando...");
                return;
        
            default:
                break;
        }
    }
}