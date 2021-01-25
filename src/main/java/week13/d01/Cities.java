package week13.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cities {

    private final static String SEPARATOR = ";";
    private List<City> cities = new ArrayList<>();

    private void readFromFile(InputStream is) {
        int counter = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                counter++;
                if (counter != 1) {
                    String parts[] = line.split(SEPARATOR);
                    addCity(parts);
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public City getFirstByAlphabet(InputStream is){
        readFromFile(is);
        Collections.sort(cities);
        return cities.get(0);
    }

    private void addCity(String[] parts){
        if(parts.length == 3){
            cities.add(new City(Integer.parseInt(parts[0]),parts[1],parts[2]));
        } else {
            cities.add(new City(Integer.parseInt(parts[0]),parts[1]));
        }
    }

}
