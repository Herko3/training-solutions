package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {

    private int[] numbers = new int[90];

    public LottoReader(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                countNumber(parts[11], parts[12], parts[13], parts[14], parts[15]);
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }

    private void countNumber(String... pulledNumbers) {
        try {
            for (String number : pulledNumbers) {
                int parsedNumber = Integer.parseInt(number);
                numbers[parsedNumber - 1] += 1;
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Cannot parse to number");
        }
    }

    public int getNumber(int number) {
        return numbers[number - 1];
    }
}
