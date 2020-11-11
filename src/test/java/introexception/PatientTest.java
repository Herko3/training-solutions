package introexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PatientTest {


    @Test
    public void testCreate(){
        Patient patient = new Patient("Jack","1254",1992);
        assertEquals("Jack",patient.getName());
        assertEquals("1254",patient.getSocialSecurityNumber());
        assertEquals(1992,patient.getYearOfBirth());

    }

    @Test
    public void testInvalidYearOfBirth(){
        assertThrows(IllegalArgumentException.class, () -> {new Patient("Jack","125",1885);});
    }

    @Test
    public void testInvalidName(){
        assertThrows(IllegalArgumentException.class, () -> {new Patient("","125",1992);});
    }

}
