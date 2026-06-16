package models;

public class WordModel {
    private String word;

    public WordModel(String word) {
        this.word = word;
    }

    public String getWord() {
        return word.toLowerCase();
    }
}
