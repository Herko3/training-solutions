package week15.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Covid {

    private Map<String, Country> countries = new HashMap<>();

    public void readFromFile(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                if (line.contains("Bonaire, Saint Eustatius and Saba")) {
                    line = line.replace("Bonaire, Saint", "Bonaire Saint");
                }
                String[] parts = line.split(",");
                modifyCountries(parts);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void modifyCountries(String[] parts) {
        if (!parts[7].isBlank()) {
            String name = parts[4];
            int number = Integer.parseInt(parts[2]);
            int pop = Integer.parseInt(parts[7]);

            if (!countries.containsKey(name)) {
                countries.put(name, new Country(name, pop, number));
            } else {
                countries.get(name).addCases(number);
            }
        }
    }

    public List<Country> getMostCasePerPopulation(int numberOfCountry){
        return countries.values()
                .stream()
                .sorted(Comparator.comparing(Country::casePerPopulation))
                .limit(numberOfCountry)
                .collect(Collectors.toList());
    }

    public Map<String, Country> getCountries() {
        return countries;
    }
}
