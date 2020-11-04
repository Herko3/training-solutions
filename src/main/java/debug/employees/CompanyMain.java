package debug.employees;

import java.util.ArrayList;

public class CompanyMain {

    public static void main(String[] args) {
    Company company = new Company(new ArrayList<>());
    Employee test = new Employee("Steve",1956);
    Employee test2 = new Employee("Stewie",1985);
    Employee test3 = new Employee("Jane",1969);

    company.addEmployee(test);
    company.addEmployee(test2);
    company.addEmployee(test3);

        System.out.println(company.findEmployeeByName("Jane").getName() +" " + company.findEmployeeByName("Jane").getYearOfBirth());

        System.out.println(company.listEmployeeNames());


    }

}
