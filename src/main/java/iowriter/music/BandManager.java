package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                addBand(parts);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public void writeBandsBefore(Path file, int year) {
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (Band band : bands) {
                if (band.getYear() < year){
                    writer.write(band.toString() + "\n");
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file!", ioe);
        }
    }

    private void addBand(String[] data) {
        if (data.length < 2) {
            throw new IllegalArgumentException("There is an invalid line");
        }
        try {
            bands.add(new Band(data[0], Integer.parseInt(data[1])));
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Year is not a number", nfe);
        }
    }

}
