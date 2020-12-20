package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students = new ArrayList<>();

    public void readGradesFromFile(String fileName) {
        Path file = Path.of("src/main/resources/ioreader/" + fileName);

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                students.add(new Student(parts[0], getGradesFromArray(parts)));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!", ioe);
        }
    }

    private List<Integer> getGradesFromArray(String[] data) {
        List<Integer> grades = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            try {
                grades.add(Integer.parseInt(data[i]));
            } catch (NumberFormatException nfe) {
                throw new IllegalStateException("Grade is not a number", nfe);
            }
        }
        return grades;
    }

    public double classAverage() {
        double averages = 0;
        for (Student student : students) {
            averages += student.average();
        }
        return averages / students.size();
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
