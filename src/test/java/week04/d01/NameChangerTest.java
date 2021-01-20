package week04.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameChangerTest {

    @Test
    public void testKonstruktor() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        assertEquals("Invalid name: ", ex.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new NameChanger(null));
        assertEquals("Invalid name: null", ex2.getMessage());

    }

    @Test
    public void testChange() {
        NameChanger test = new NameChanger("Szabó László");
        assertEquals("Szabó Péter", test.changeFirstName("Péter"));
    }
}