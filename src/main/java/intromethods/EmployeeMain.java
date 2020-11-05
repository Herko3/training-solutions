package intromethods;

public class EmployeeMain {

    public static void main(String[] args) {
        Employee test = new Employee("Jack",1985, 2_000_000);

        System.out.println(test);
        test.setName("Joe");
        System.out.println("név váltás" + test);

        test.raiseSalary(15000);
        System.out.println("Emelés" + test);
    }
}
