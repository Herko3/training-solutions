package week05.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeLetterTest {

    @Test
    public void testMethod(){
        ChangeLetter test = new ChangeLetter();
        assertEquals("*****",test.changeVowels("aeiou"));
        assertEquals("*lm*",test.changeVowels("alma"));
    }

    @Test
    public void testException(){
        ChangeLetter test = new ChangeLetter();

        Exception ex = assertThrows(IllegalArgumentException.class,()->test.changeVowels(""));
        assertEquals("A szöveg nem lehett üres vagy null!",ex.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class,()->test.changeVowels(null));
        assertEquals("A szöveg nem lehett üres vagy null!",ex2.getMessage());

    }

}
