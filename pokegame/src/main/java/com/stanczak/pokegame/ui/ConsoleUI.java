package com.stanczak.pokegame.ui;

import java.util.Scanner;

import com.stanczak.pokegame.util.ClearTerminal;

public class ConsoleUI {
    public void start(Scanner scanner) {
        boolean inMenu = true;

        while(inMenu){
            ClearTerminal.clearTerminal();
            System.out.println("Menu de opções");
            System.out.println("Por favor, selecione uma opção:");
            System.out.println("1 - Batalha");
            System.out.println("2 - Pokedex");
            System.out.println("3 - Voltar");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    ClearTerminal.clearTerminal();
                    BattleConsole.battle(scanner);
                    break;
                case 2:
                    ClearTerminal.clearTerminal();
                    Pokedex.pokedex(scanner);
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
    }