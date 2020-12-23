package week09.d03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SantaClaus {

    private List<Person> persons = new ArrayList<>();

    public SantaClaus(List<Person> persons) {
        this.persons = persons;
    }

    public void getThroughChimneys(){
        for (Person person : persons){
            person.setPresent();
        }
    }
}
