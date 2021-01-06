package week10.d02;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    @Test
    void test() {
        InputStream is = Travel.class.getResourceAsStream("utasadat.txt");
        Stop test = Travel.getStopWithMax(is);
        assertEquals("0", test.getId());
        assertEquals(3, test.getNumberOfPassengers());
    }


}