package controller;

import models.WordModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Reader {
    private WordModel wordModel;

    public Reader() {
        String word = getWord(); // Fix the type to String
        wordModel = new WordModel(word);
    }
    private String getWord() {
        List<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\amitd\\IdeaProjects\\24 wordgame\\wordlist.txt"));
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine().trim());
            }
        } catch (FileNotFoundException ignored) {}
        if (!words.isEmpty()) {
            int index = new Random().nextInt(words.size());
            return words.get(index); // Return as String
        }

        return null;
    }  public int getWordLength() {return wordModel.getWord().length();}public char[] getWordLetters() {
        return wordModel.getWord().toCharArray();
    }
}
