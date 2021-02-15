package week16.d01;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class VowelFilterTest {

    @Test
    void testReplace() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/week16.d01/test.txt"));
        System.out.println(VowelFilter.filterVowels(reader));
    }

}