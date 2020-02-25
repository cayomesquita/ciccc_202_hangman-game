package ca.ciccc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordGenerator {
    private String word;
    private String FILE_CITIES = "cities.txt";
    private char hide = '-';
    Path filePath = Paths.get(FILE_CITIES);
    private char[] chars;

    public WordGenerator() throws FileNotFoundException {
        Path path = Paths.get(FILE_CITIES);
        try (Stream<String> lines = Files.lines(path)) {
            List<String> citiesList = lines.collect(Collectors.toList());
            int randomIndex = Double.valueOf(Math.random() * citiesList.size()).intValue();
            setWord(citiesList.get(randomIndex));
            //return citiesList.get(randomIndex);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String hiddenWord() {
        String word = this.word;
        String hiddenWord = "";
        chars = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            chars[i] = word.charAt(i);
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                hiddenWord += "_ ";
            } else {
                hiddenWord += " ";
            }
        }
        return hiddenWord;
    }
}
