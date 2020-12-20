package week08.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Plane {


    public int longestOcean(Path path) {
        int oceanSize = 0;
        int actual = 0;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int number;

            while ((number = reader.read()) != -1) {
                char c = (char) number;

                if (c == '0') {
                    actual++;
                }
                if (c == '1') {
                    if (actual > oceanSize) {
                        oceanSize = actual;
                    }
                    actual = 0;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return oceanSize;
    }
}
