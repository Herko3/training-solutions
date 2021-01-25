package week13.d01;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CitiesTest {

    @Test
    void testGetFirstByAlphabet(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("week13/d01/iranyitoszamok-varosok-2021.csv");

        City result = new Cities().getFirstByAlphabet(is);

        assertEquals(8127, result.getZipCode());
        assertEquals("Aba", result.getCity());
    }

}