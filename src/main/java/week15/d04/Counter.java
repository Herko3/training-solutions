package week15.d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Counter {

    public Map<CharType, Long> count(Path path) {
        try (Stream<String> stream = Files.lines(path)) {
            return stream.map(String::toLowerCase)
                    .flatMapToInt(String::chars)
                    .filter(i->i != (int) ' ')
                    .mapToObj(CharType::getType)
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file");
        }
    }

}
