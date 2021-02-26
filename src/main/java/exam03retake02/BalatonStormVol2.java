package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BalatonStormVol2 {

    public static final int LEVELOFSTORM = 3;
    public static final String SEPARATOR = ": ";

    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        List<String> result = new ArrayList<>();
        String station = null;
        String line;
        while ((line = reader.readLine()) != null) {

            if (line.contains("allomas")) {
                station = line.substring(line.indexOf(SEPARATOR) + 3, line.length() - 2);
            }
            if (line.contains("level")) {
                try {
                    String level = line.substring(line.indexOf(SEPARATOR) + 2, line.length() - 1);
                    int stormLevel = Integer.parseInt(level);

                    if (stormLevel == LEVELOFSTORM) {
                        result.add(station);
                    }

                } catch (NumberFormatException nfe) {
                    throw new IllegalStateException("Not a number");
                }
            }

        }
        Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
        return result;
    }

}
