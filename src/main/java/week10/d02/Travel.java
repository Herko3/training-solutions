package week10.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Travel {

    private static List<Stop> stops = new ArrayList<>();

    public static Stop getStopWithMax(InputStream is) {
        readFromFile(is);
        Stop maxPassenger = stops.get(0);
        for (Stop stop : stops) {
            if(stop.getNumberOfPassengers() > maxPassenger.getNumberOfPassengers()){
                maxPassenger = stop;
            }
        }
        return maxPassenger;
    }

    private static void readFromFile(InputStream is){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(" ");
                stopData(parts[0]);
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private static void stopData(String s){
        for(Stop stop : stops){
            if(stop.getId().equals(s)){
                stop.plusPassenger();
                return;
            }
        }
        stops.add(new Stop(s));
    }

}
