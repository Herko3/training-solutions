package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    Map<String,Integer> owlsPerState = new HashMap<>();

    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        while((line= reader.readLine()) != null){
            String[] parts = line.split("=");
            owlsPerState.put(parts[0],Integer.parseInt(parts[1]));
        }
    }

    public int getNumberOfOwls(String state){
        return owlsPerState.get(state);
    }
}
