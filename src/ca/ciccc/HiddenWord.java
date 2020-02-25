package ca.ciccc;

import javafx.print.Collation;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HiddenWord {

    private static final char CHAR_UNDERSCORE = '_';
    private static final char CHAR_SPACE = ' ';

    private char[] word;
    private char[] hiddenWord;

    public HiddenWord(String word) {
        this.word = word.trim().toCharArray();
        this.hiddenWord = new char[this.word.length];
        for (int index = 0; index < this.hiddenWord.length; index++) {
            this.hiddenWord[index] = Character.isSpaceChar(this.word[index]) ? CHAR_SPACE : CHAR_UNDERSCORE;
        }
    }

    public String getHiddenWord() {
        return new String(this.hiddenWord).chars()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public String getWord() {
        return new String(this.word);
    }

    public boolean applyLetter(String letterStr) {
        boolean found = false;
        char letter = letterStr.charAt(0);
        for (int index = 0; index < this.word.length; index++) {
            if (Character.toLowerCase(word[index]) == letter) {
                found = true;
                this.hiddenWord[index] = this.word[index];
            }
        }
        return found;
    }

    public boolean isComplete() {
        for (char c : this.hiddenWord) {
            if (CHAR_UNDERSCORE == c) {
                return false;
            }
        }
        return true;
    }
}
