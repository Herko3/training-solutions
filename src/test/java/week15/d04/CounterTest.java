package week15.d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void testCount(){
        Path path = Path.of("src/main/resources/week15/d04/test.txt");

        Counter counter = new Counter();
        Map<CharType, Long> result = counter.count(path);

        assertEquals(14,result.get(CharType.VOWEL));
        assertEquals(77,result.get(CharType.CONSONANT));
        assertEquals(5,result.get(CharType.OTHER));
    }

}