package week12.d05;

import org.junit.jupiter.api.Test;
import week12.d05.Junior.CoronavirusCounter;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFilterTest {

    @Test
    void testMethod() {
        List<Employee> parameter = List.of(
                new Employee(15, 2, "Jack", Arrays.asList("programming", "cooking", "dying")),
                new Employee(21, 3, "John", Arrays.asList("cooking", "dying")),
                new Employee(19, 5, "Joe", Arrays.asList("programming", "cooking", "dying")),
                new Employee(18, 1, "Scott", Arrays.asList("programming", "cooking", "dying")),
                new Employee(32, 4, "Danielle", Arrays.asList("programming", "cooking"))
        );

        List<Employee> expected = List.of(
                new Employee(19, 5, "Joe", Arrays.asList("programming", "cooking", "dying")),
                new Employee(32, 4, "Danielle", Arrays.asList("programming", "cooking"))
        );

        assertEquals(2, new EmployeeFilter().countSeniorDevs(parameter).size());
        assertEquals(expected, new EmployeeFilter().countSeniorDevs(parameter));
    }

}