package debug.employees;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employee;

    public Company(List<Employee> employee) {
        this.employee = employee;
    }

    public void addEmployee(Employee felvetel) {
        employee.add(felvetel);
    }

    public Employee findEmployeeByName(String name) {
        for (Employee search : employee) {
            if (search.getName().equals(name)) {
                return search;
            }
        }
        return null;
    }

    public List<String> listEmployeeNames() {
        List<String> names = new ArrayList<>();
        for (Employee all : employee) {
            names.add(all.getName());
        }

        return names;
    }
}
