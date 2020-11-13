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
        if (!students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    }

    public double calculateClassAverage() {
        return 0.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        return 0.0;
    }

    public Student findStudentByName(String name) {
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

    public boolean isEmpty(String test){
        if(test==null || test.trim().equals("")){
            return true;
        }
        return false;
    }

    public String listStudentNames(){
        return "LATER";
    }

    public List<StudyResultByName> listStudyResults(){
        return null;
    }

    public boolean removeStudent(Student student){
        if (students.contains(student)){
            students.remove(student);
            return true;
        }
        return false;
    }
    public Student repetition(){
        return null;
    }

}
