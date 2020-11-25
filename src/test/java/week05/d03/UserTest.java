package week05.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void testValidate(){
        UserValidator test = new UserValidator();
        Exception ex = assertThrows(RuntimeException.class, () -> test.validate(new User("",15)));
        assertEquals("User name must not be empty or null!",ex.getMessage());
        Exception ex2 = assertThrows(RuntimeException.class, () -> test.validate(new User(null,15)));
        assertEquals("User name must not be empty or null!",ex2.getMessage());

        Exception ex3 = assertThrows(RuntimeException.class, () -> test.validate(null));
        assertEquals("No user to validate",ex3.getMessage());

        Exception ex4 = assertThrows(RuntimeException.class, () -> test.validate(new User("Peti",-15)));
        assertEquals("User age most be valid and under 120",ex4.getMessage());

        Exception ex5 = assertThrows(RuntimeException.class, () -> test.validate(new User("Peti",121)));
        assertEquals("User age most be valid and under 120",ex5.getMessage());
    }
}
