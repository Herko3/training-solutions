package week14.d04;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public Employee convert(Employee e){
        return new Employee(e.name.toUpperCase());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
