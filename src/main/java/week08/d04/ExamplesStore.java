package week08.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {

    public List<String> getTitlesOfExamples(String fileName){
        List<String> titles = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(ExamplesStore.class.getResourceAsStream(fileName)))){
            String line;
            while ((line = reader.readLine()) != null){
                if(line.startsWith("#")){
                    titles.add(line);
                }
            }
        } catch (IOException ioe){
            throw new IllegalStateException("Cannot read file");
        }
        return titles;
    }
}
