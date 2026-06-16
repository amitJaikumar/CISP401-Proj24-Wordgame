package view;

import controller.Reader;
import java.util.Scanner;

public class View {
    private final Reader reader;
    private int remainingGuesses;
    private final char[] guessedWord;
    private boolean cheatMode;

    public View(Reader reader, int totalGuesses, boolean cheatMode) {
        this.reader = reader;
        this.remainingGuesses = totalGuesses;
        this.guessedWord = new char[reader.getWordLength()];
        this.cheatMode = cheatMode;
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
    }

    public void introduceGame() {
        System.out.println("Welcome to the Word Game!");
        if (cheatMode) {
            System.out.println("Cheat mode enabled. The word is: " + new String(reader.getWordLetters()));
        }
    }

    public void displayWord() {
        System.out.println("The word has " + reader.getWordLength() + " letters.");
        System.out.println(guessedWord);
    }

    public void promptGuess() {
        Scanner scanner = new Scanner(System.in);
        while (remainingGuesses > 0) {
            System.out.println("Enter a letter:");
            char guess = scanner.nextLine().charAt(0);
            if (checkGuess(guess)) {
                updateGuessedWord(guess);
            } else {
                remainingGuesses--;
            }
            System.out.println(guessedWord);
            System.out.println("Remaining guesses: " + remainingGuesses);
            if (new String(guessedWord).equals(new String(reader.getWordLetters()))) {
                System.out.println("Congratulations! You've guessed the word!");
                return;
            }
        }
        System.out.println("Sorry, you've run out of guesses. The word was: " + new String(reader.getWordLetters()));
    }

    private boolean checkGuess(char guess) {
        char[] wordLetters = reader.getWordLetters();
        for (char letter : wordLetters) {
            if (letter == guess) {
                return true;
            }
        }
        return false;
    }

    private void updateGuessedWord(char guess) {
        char[] wordLetters = reader.getWordLetters();
        for (int i = 0; i < wordLetters.length; i++) {
            if (wordLetters[i] == guess) {
                guessedWord[i] = guess;
            }
        }
    }
}
