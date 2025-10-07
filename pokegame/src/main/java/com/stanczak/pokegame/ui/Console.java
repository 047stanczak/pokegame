package com.stanczak.pokegame.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public final class Console {
    private final Scanner scanner;
    private final PrintStream out;

    public Console(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    public Console(InputStream in, PrintStream out){
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public void println(String msg) {
        out.println(msg);
    }

    public void printf(String fmt, Object... args) {
        out.printf(fmt, args);
        out.println();
    }

    public String readLine(String prompt) {
        if (prompt != null && !prompt.isEmpty()) {
            out.print(prompt);
            out.flush();
        }
        return scanner.nextLine();
    }

    public void clearScreen() {
        out.print("\033[H\033[2J");
        out.flush();
    }

    public void close() {
        scanner.close();
    }
}
