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

    private static final String FILE_CITIES = "cities.txt";

    private List<String> list;

    public WordGenerator() throws IOException {
        updateList();
    }

    public void updateList() throws IOException {
        Path path = Paths.get(FILE_CITIES);
        try (Stream<String> lines = Files.lines(path)) {
            this.list = lines.collect(Collectors.toList());
        }
    }

    public String randomWord() {
        int randomIndex = Double.valueOf(Math.random() * this.list.size()).intValue();
        return this.list.get(randomIndex);
    }

}
