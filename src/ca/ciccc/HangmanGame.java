package ca.ciccc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HangmanGame {

    public static final int LIMIT_GUESSES = 10;
    public static final String DELIMITER_SPACE = " ";


    private ArrayList<String> wrongGuesses;

    public HangmanGame() {
        this.wrongGuesses = new ArrayList();
    }

    public void start() throws IOException {
        WordGenerator wordGenerator = new WordGenerator();

        HiddenWord word = new HiddenWord(wordGenerator.randomWord());

        //System.out.println(word.getWord());
        System.out.println("Here's the question");
        System.out.println(word.getHiddenWord());
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Guess a letter: ");
                String input = scanner.next().trim().toLowerCase();

                if (isValidInput(input)) {
                    if (word.applyLetter(input)) {
                        if (word.isComplete()) {
                            System.out.println("You win!");
                            System.out.printf("You have guessed '%s' correctly.", word.getWord());
                            break;
                        }
                    } else {
                        this.wrongGuesses.add(input);
                        if (this.wrongGuesses.size() > LIMIT_GUESSES) {
                            System.out.println("You lose!");
                            System.out.printf("The correct word was '%s'", word.getWord());
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid input, please try again!");
                    continue;
                }
                System.out.printf("You are guessing: %s\n", word.getHiddenWord());
                System.out.printf("You have guesses (%d) wrong letters: %s\n", getWrongGuessesCount(), getListWrongGuesses());
            }
        }

    }

    private int getWrongGuessesCount() {
        return this.wrongGuesses.size();
    }

    private String getListWrongGuesses() {
        return this.wrongGuesses.stream()
                .collect(Collectors.joining(DELIMITER_SPACE));
    }

    private boolean isValidInput(String input) {
        return input.length() == 1;
    }

}
