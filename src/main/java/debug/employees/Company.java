package debug.employees;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> company;

    public Company(List<Employee> company) {
        this.company = company;
    }

    public void addEmployee(Employee felvetel) {
        company.add(felvetel);
    }

    public Employee findEmployeeByName(String name) {
        for (Employee search : company) {
            if (search.getName().equals(name)) {
                return search;
            }
        }
        return null;
    }

    public List<String> listEmployeeNames() {
        List<String> names = new ArrayList<>();
        for (Employee all : company) {
            names.add(all.getName());
        }

        return names;
    }
}
