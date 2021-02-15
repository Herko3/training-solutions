package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public String createHistogram(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(createLine(line));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return sb.toString();
    }

    private String createLine(String s) {
        StringBuilder sb = new StringBuilder();
        try {
            int number = Integer.parseInt(s);
            for (int i = 0; i < number; i++) {
                sb.append("*");
            }

        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Not a number: " + s);
        }
        return sb.append("\n").toString();
    }
}
