package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString){

        byte[] data = new byte[0];
        try {
            data = Files.readAllBytes(Path.of(pathString));
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read file", exception);
        }

        return new Temperatures(data);
    }

}
