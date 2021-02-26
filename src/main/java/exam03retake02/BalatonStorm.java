package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class BalatonStorm {

    public static final int STORMLEVEL = 3;
    private Map<Integer,List<String>> stationByStormLevel = new HashMap<>();

    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {

        String station = null;
        String stormLevel;
        String line;
        while((line = reader.readLine()) != null){

            if(line.contains("allomas")){
                station = line.substring(line.indexOf(": ") + 3, line.length() - 2);
            }
            if(line.contains("level")){
                stormLevel = line.substring(line.indexOf(": ") + 2, line.length() - 1);
                addStation(station,stormLevel);
            }
        }
        List<String> result = stationByStormLevel.get(STORMLEVEL);
        Collections.sort(result,Collator.getInstance(new Locale("hu", "HU")));
        return result;
    }

    private void addStation(String station, String stormLevel){
        try{
            int level = Integer.parseInt(stormLevel);
            if(!stationByStormLevel.containsKey(level)){
                stationByStormLevel.put(level,new ArrayList<>());
            }
            stationByStormLevel.get(level).add(station);

        } catch (NumberFormatException nfe){
            throw new IllegalStateException("Storm level is not a number! Value: " + stormLevel);
        }
    }
}
