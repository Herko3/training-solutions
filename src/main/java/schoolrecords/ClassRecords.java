package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd = new Random();
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public boolean addStudent(Student student) {
        for (Student search : students)
            if (search.getName().equals(student.getName())) {
                System.out.println("Ez a diák már szerepel a listában!");
                return false;
            }
        students.add(student);
        System.out.println("Sikeres felvétel: " +student.getName());
        return true;
    }


    public double calculateClassAverage() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        int studentWithMark = 0;
        double sum = 0.0;
        for (Student student : students) {
            double sumPerson = student.calculateAverage();
            if (sumPerson != 0) {
                sum += sumPerson;
                studentWithMark++;
            }
        }
        if (studentWithMark == 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }

        return sum / students.size();
    }

    public double calculateClassAverageBySubject(Subject subject) {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        int numberOfAverage = 0;
        double sum = 0.0;
        for (Student student : students) {
            double sumPerson = student.calculateSubjectAverage(subject);
            if (sumPerson != 0.0) {
                sum += sumPerson;
                numberOfAverage++;
            }
        }
        return sum / numberOfAverage;
    }

    public Student findStudentByName(String name) {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    public String getClassName() {
        return className;
    }

    public boolean isEmpty(String test) {
        if (test == null || test.trim().equals("")) {
            return true;
        }
        return false;
    }

    public String listStudentNames() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            if (i == students.size() - 1) {
                builder.append(students.get(i).getName());
            } else {
                builder.append(students.get(i).getName());
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> results = new ArrayList<>();
        for (Student student : students) {
            results.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }

        return results;
    }

    public boolean removeStudent(Student student) {
        for (Student search : students)
            if (search.getName().equals(student.getName())) {
                students.remove(student);
                return true;
            }
        return false;
    }

    public Student repetition() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));
    }
}
