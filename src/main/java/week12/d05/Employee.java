package week12.d05;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {

    private int age;
    private int skillLevel;
    private String name;
    private List<String> skills;

    public Employee(int age, int skillLevel, String name, List<String> skills) {
        this.age = age;
        this.skillLevel = skillLevel;
        this.name = name;
        this.skills = new ArrayList<>(skills);
    }

    public int getAge() {
        return age;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && skillLevel == employee.skillLevel && Objects.equals(name, employee.name) && Objects.equals(skills, employee.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, skillLevel, name, skills);
    }
}
