package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public double calculateAverage() {
        if(marks.isEmpty()){
            return 0.0;
        }
        double sum = 0.0;
        for (Mark mark : marks) {
            sum += mark.getMarkType().getValue();
        }
        double factor = Math.pow(10,2);
        return Math.round(sum / marks.size()*factor)/factor;
    }

    public double calculateSubjectAverage(Subject subject) {
        if(marks.isEmpty()){
            return 0.0;
        }
        double sum = 0.0;
        int number =0;
        for (Mark mark : marks) {
            if (mark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sum += mark.getMarkType().getValue();
                number++;
            }
        }
        if(sum == 0.0){
            return 0.0;
        }
        double factor = Math.pow(10,2);
        return Math.round(sum / number * factor)/factor;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public boolean isEmpty(String test) {
        if (test == null || test.trim().equals("")) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(name);
        builder.append(" marks: ");
        for(Mark mark : marks){
            builder.append(mark.getSubject().getSubjectName());
            builder.append(": ");
            builder.append(mark.toString());
        }

        return builder.toString();
    }
}
