package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private List<Country> countryList = new ArrayList<>();

    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream("/" + fileName)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                countryList.add(new Country(parts[0],Integer.parseInt(parts[1])));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        } catch (NumberFormatException nfe){
            throw new IllegalStateException("The number of neighbours is not a number", nfe);
        }
    }

    public int numberOfCountries(){
        return countryList.size();
    }

    public Country mostBorderCountries(){
        Country result = null;
        int neighbor = 0;
        for(Country country: countryList){
            int actualNeighbor = country.getNeighbors();
            if(actualNeighbor > neighbor){
                result = country;
                neighbor = actualNeighbor;
            }
        }
        return result;
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }
}
