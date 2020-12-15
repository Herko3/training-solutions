package week08.d02;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryStatistics {

    private List<Country> countries = new ArrayList<>();

    public void init(String path) {
        try (Scanner sc = new Scanner(Path.of(path))) {
            while (sc.hasNextLine()) {
                Country country = countryMaker(sc.nextLine());
                countries.add(country);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    public Country maxPopulation() {
        int population = 0;
        Country result = null;
        for (Country country : countries) {
            if (population < country.getPopulation()) {
                result = country;
                population = country.getPopulation();
            }
        }

        return result;
    }

    public List<Country> getCountries() {
        return List.copyOf(countries);
    }

    private Country countryMaker(String line) {
        String[] countryStats = line.split(" ");
        validate(countryStats);

        return new Country(countryStats[0],
                Integer.parseInt(countryStats[1]),
                Integer.parseInt(countryStats[2]),
                Integer.parseInt(countryStats[3]));

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
