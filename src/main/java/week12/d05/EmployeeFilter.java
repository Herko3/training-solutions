package week12.d05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeFilter {

    public List<Employee> countSeniorDevs(List<Employee> employees) {
        List<Employee> found = new ArrayList<>(employees);
        Iterator<Employee> iterator = found.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();

            if (employee.getSkillLevel() < 3 || !(employee.getSkills().contains("programming"))) {
                iterator.remove();
            }
        }
        return found;
    }

}
