package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Diary {

    private Path dir = Path.of("src", "main", "resources");

    public void newMark(Path path, int grade) {
        try {
            if (Files.exists(dir.resolve(path))) {
                Files.writeString(dir.resolve(path), grade + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(dir.resolve(path), grade + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    public void average(Path path) {
        double sum = 0;
        try {
            List<String> marks = Files.readAllLines(path);
            for (String mark : marks) {
                sum += Double.parseDouble(mark);
            }

            Files.writeString(dir.resolve(path), "average: " + sum / marks.size(), StandardOpenOption.APPEND);

        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read file");
        }

    }
}
