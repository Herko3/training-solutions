package week11.d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    public void testCounter(){
        CharCounter charCounter = new CharCounter();

        assertEquals(2,charCounter.countChars(new String[]{"abc", "cba", "ab"}));
    }

}