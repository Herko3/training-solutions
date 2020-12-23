package week09.d03;

import java.util.Random;

public class Person {

    private String name;
    private int age;
    Present present;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPresent() {
        Random rnd = new Random();
        present = Present.values()[rnd.nextInt(Present.values().length)];
        if (age > 14 && present == Present.TOY) {
            setPresent();
        }
    }
}
