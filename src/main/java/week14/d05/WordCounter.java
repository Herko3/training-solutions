package week14.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordCounter {


    public long countWords(Path path, String word) {
        long counted;
        try (Stream<String> stream = Files.lines(path)) {
            counted = stream
                    .filter(line -> line.contains(word))
                    .flatMap(WordCounter::lineToWorlds)
                    .filter(s -> s.contains(word))
                    .count();

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return counted;
    }

    private static Stream<? extends String> lineToWorlds(String line) {
        return Arrays.stream(line.split(" "));
    }

    public Map<String, Integer> countWords(Path path, String... words) {
        Map<String, Integer> result = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : words) {
                    if (line.toLowerCase().contains(word.toLowerCase())) {
                        if (result.containsKey(word)) {
                            result.replace(word, result.get(word) + 1);
                        } else {
                            result.put(word, 1);
                        }
                    }
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return result;
    }

}
