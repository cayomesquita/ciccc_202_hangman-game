package ca.ciccc;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        HangmanGame game = new HangmanGame();
        game.start();
    }
}
