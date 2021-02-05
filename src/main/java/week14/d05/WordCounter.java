package week14.d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class WordCounter {

    public long countWords(Path path, String word) {
        long counted;
        try (Stream<String> stream = Files.lines(path)) {
            counted = stream
                    .filter(line -> line.contains(word))
                    .count();

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return counted;
    }

}
