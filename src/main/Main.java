package main;

import controller.Reader;
import view.View;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        View view = new View(reader, 10, true); // 10 guesses, cheat mode enabled
        view.introduceGame();
        view.displayWord();
        view.promptGuess();
    }
}

