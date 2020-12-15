package ioreadstring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private Path myFile;
    private List<Human> humans = new ArrayList<>();

    public FileManager(String path) {
        myFile = Path.of(path);
    }

    public List<Human> getHumans() {
        return humans;
    }

    public Path getMyFile() {
        return myFile;
    }

    public void readFromFile() {
        try {
            List<String> lines = Files.readAllLines(myFile);
            for(String line : lines){
                String[] parts = line.split(" ");
                humans.add(new Human(parts[0],parts[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read File", ioe);
        }
    }

}
