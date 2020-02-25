package ca.ciccc;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HangmanGame {
    private char guess;
    private String word;
    private Scanner scanner;
    int limit_tentatives = 10;

    public HangmanGame() throws FileNotFoundException {
        WordGenerator wordGenerator = new WordGenerator();
        this.word = wordGenerator.getWord();
        scanner = new Scanner(System.in);

    }

    public char getGuess() {
        return guess;
    }

    public void setGuess(char guess) {
        this.guess = guess;
    }

    public int getLimit_tentatives() {
        return limit_tentatives;
    }

    public void start() {
        int guessCount = 0;

    }
}
