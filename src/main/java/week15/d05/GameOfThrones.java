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

public class GameOfThrones {

    public List<Houses> count(InputStream is) {
        Map<String, Houses> battles = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                if (line.contains("Invasion of Ryamsport, Vinetown, and Starfish Harbor")){
                    line = line.replace("Invasion of Ryamsport, Vinetown, and Starfish Harbor","Invasion of Ryamsport Vinetown and Starfish Harbor");
                }

                String[] parts = line.split(",");
                for (int i = 5; i <= 12; i++){
                    if(!parts[i].isBlank()){
                        String house = parts[i];
                        if(!battles.containsKey(house)){
                            battles.put(house,new Houses(house,1));
                        } else {
                            battles.get(house).addBattle();
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return battles.values()
                .stream()
                .sorted(Comparator.comparing(Houses::getNumberOfBattles).reversed())
                .collect(Collectors.toList());
    }

}
