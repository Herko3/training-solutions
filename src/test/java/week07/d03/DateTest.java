package week07.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    Date date = new Date(1192, 10, 15);

    @Test
    public void testOf() {
        Date test = Date.of(1585, 12, 26);
        assertEquals(1585, test.getYear());
        assertEquals(12, test.getMonth());
        assertEquals(26, test.getDay());
    }

    @Test
    public void testWithYear() {
        assertEquals(1858, date.withYear(1858).getYear());
    }

    @Test
    public void testWithMonth() {
        assertEquals(9, date.withMonth(9).getMonth());
    }

    @Test
    public void testWithDay() {
        assertEquals(25, date.withDay(25).getDay());
    }

    @Test
    public void testException(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Date(1992,15,30));
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new Date(1992,12,45));

        assertEquals("Date is not valid",ex.getMessage());
        assertEquals("Date is not valid",ex2.getMessage());
    }


}