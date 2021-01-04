package week10.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HikingFile {

    private List<Double> elevations = new ArrayList<>();

    public Hiking getElevation(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(HikingFile.class.getResourceAsStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                elevations.add(Double.parseDouble(parts[2]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Elevation is not a number", nfe);
        }
        return getAttributes();
    }

    private Hiking getAttributes() {
        double ascend = 0;
        double descend = 0;
        double previous = elevations.get(0);
        for (double elevate : elevations) {
            if (elevate < previous) {
                descend += previous - elevate;
            }
            if (elevate > previous) {
                ascend += elevate - previous;
            }
            previous = elevate;
        }
        return new Hiking(ascend, descend);
    }

}
