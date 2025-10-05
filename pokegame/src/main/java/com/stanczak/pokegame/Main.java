package com.stanczak.pokegame;

import java.util.Scanner;

import com.stanczak.pokegame.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Seja bem vindo ao pokegame!");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Jogar");
            System.out.println("2 - Sair");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    ConsoleUI consoleUi = new ConsoleUI();
                    consoleUi.start(scanner);
                    break;
                case 2:
                    System.out.println("Saindo...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
        }
    }
}

}

