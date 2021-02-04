package week14.d04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTransformOperations {

    public List<Employee> transformToUppercased (List<Employee> employees){
       return employees.stream()
                .map(Employee::convert)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
          new Employee("Dave"),
          new Employee("Pete")
        );

        System.out.println(new EmployeeTransformOperations().transformToUppercased(list));
        System.out.println(list);
    }

}
