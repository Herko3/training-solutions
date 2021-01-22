package week12.d05.Junior;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CoronavirusCounter {

    public int searchForWord(String word, InputStream is) {
        int counter = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                if (line.contains(word.toLowerCase())) {
                    counter++;
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return counter;
    }

}
