package week08.d02;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryStatistics {

    private List<String> statistics = new ArrayList<>();

    public void init(String path) {
        try (Scanner sc = new Scanner(Path.of(path))) {
            while (sc.hasNextLine()) {
                statistics.add(sc.nextLine());
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    public String maxPopulation() {
        String result = "";
        int population = 0;
        for (String line : statistics) {
            String[] countryStats = line.split(" ");
            validate(countryStats);

            int actual = Integer.parseInt(countryStats[1]);
            if (population < actual) {
                result = line;
                population = actual;
            }
        }

        return result;
    }

    public List<String> getStatistics() {
        return List.copyOf(statistics);
    }

    private void validate(String[] toValidate) {
        try {
            Integer.parseInt(toValidate[1]);
            Integer.parseInt(toValidate[2]);
            Integer.parseInt(toValidate[3]);

        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("The line has a wrong data", nfe);
        }
    }
}
