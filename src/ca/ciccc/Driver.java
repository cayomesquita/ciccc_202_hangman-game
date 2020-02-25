package ca.ciccc;

import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        WordGenerator wordGenerator = new WordGenerator();

        System.out.println(wordGenerator.getWord());
        System.out.println(wordGenerator.hiddenWord());

    }
}
