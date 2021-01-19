package week12.d02;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadFromFile {

    private int odd = 1;
    private int even = 2;
    private List<House> houseList = new ArrayList<>();

    public ReadFromFile(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                createNewHouse(parts);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void createNewHouse(String[] parts) {
        if ("0".equals(parts[0])) {
            houseList.add(new House(even, Integer.parseInt(parts[1]), parts[2]));
            even += 2;
        }
        if ("1".equals(parts[0])) {
            houseList.add(new House(odd, Integer.parseInt(parts[1]), parts[2]));
            odd += 2;
        }

    }

    public List<House> housesByArea() {
        List<House> sorted = new ArrayList<>(houseList);
        Collections.sort(sorted);
        return sorted;
    }

    public int lastNumber() {
        int size = houseList.size();
        return houseList.get(size - 1).getHouseNumber();
    }

    public void writeOddStreetView(Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(oddsFormList());

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    private String oddsFormList() {
        StringBuilder sb = new StringBuilder();
        for (House house : houseList) {
            if (house.getHouseNumber() % 2 != 0) {
                sb.append("(" + house.getHouseNumber() + ")");
                for (int j = 0; j < house.getWidth(); j++) {
                    sb.append(house.getColorOfHedge());
                }
            }
        }
        return sb.toString();
    }

    public List<House> getHouseList() {
        return new ArrayList<>(houseList);
    }
}
