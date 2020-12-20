package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Integer> gradeList = new ArrayList<>();

    public Student(String name, List<Integer> gradeList) {
        this.name = name;
        this.gradeList = gradeList;
    }

    public double average() {
        if (gradeList.isEmpty()) {
            throw new IllegalArgumentException("No grades!");
        }
        double sum = 0;
        double grades = 0;

        for (int grade : gradeList) {
            sum += grade;
            grades++;
        }

        return sum / grades;
    }

    public boolean isIncreasing() {
        for (int i = 1; i < gradeList.size(); i++) {
            if (gradeList.get(i - 1) > gradeList.get(i)){
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }


}
