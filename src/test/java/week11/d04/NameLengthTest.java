package week11.d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameLengthTest {

    @Test
    public void testMethod() {
        NameLength nameLength = new NameLength();
        List<Integer> result = nameLength.getLengths(List.of("Joe", "Jack", "Jane", "George", "William"));

        assertEquals(2, result.size());
        assertEquals("[3, 4]", result.toString());
    }
}