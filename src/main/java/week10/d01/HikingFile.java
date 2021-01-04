package week10.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HikingFile {

    private List<Integer> elevations = new ArrayList<>();

    public Hiking getElevation(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(HikingFile.class.getResourceAsStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                elevations.add(Integer.parseInt(parts[2]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Elevation is not a number", nfe);
        }
        return getAttributes();
    }

    private Hiking getAttributes() {
        int ascend = 0;
        int descend = 0;
        int previous = elevations.get(0);
        for (int i : elevations) {
            if (i < previous) {
                descend += previous - i;
            }
            if (i > previous) {
                ascend += i - previous;
            }
            previous = i;
        }
        return new Hiking(ascend, descend);
    }

}
