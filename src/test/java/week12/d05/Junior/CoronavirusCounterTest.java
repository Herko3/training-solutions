package week12.d05.Junior;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CoronavirusCounterTest {

    @Test
    void testCounter(){
        InputStream is = CoronavirusCounter.class.getResourceAsStream("Index.html");

        assertEquals(9,new CoronavirusCounter().searchForWord("koronavírus",is));
    }

}