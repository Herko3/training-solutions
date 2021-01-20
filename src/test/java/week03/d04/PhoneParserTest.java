package week03.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneParserTest {

    @Test
    public void testPrefix() {
        assertEquals(30,new PhoneParser().parsePhone("30-1234567").getPrefix() );
    }

    @Test
    public void testNumber() {
        assertEquals(1234567,new PhoneParser().parsePhone("30-1234567").getNumber() );
    }
}
