package week11.d02;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {


    @Test
    void addRide() {
        InputStream inputStream = Courier.class.getResourceAsStream("rides.txt");
        Courier courier = new Courier();
        courier.addRide(inputStream);
        assertEquals(61, courier.getRides().size());
    }

    @Test
    void firstRide() {
        InputStream inputStream = Courier.class.getResourceAsStream("rides.txt");
        Courier courier = new Courier();
        courier.addRide(inputStream);
        assertEquals(1, courier.firstRide().getDay());
        assertEquals(1, courier.firstRide().getRideNumber());
        assertEquals(3, courier.firstRide().getDistance());
    }

    @Test
    void workDays() {
        InputStream inputStream = Courier.class.getResourceAsStream("rides.txt");
        Courier courier = new Courier();
        courier.addRide(inputStream);
        assertTrue(courier.workDays()[0]);
        assertFalse(courier.workDays()[5]);
    }

    @Test
    void dailyDistance() {
        InputStream inputStream = Courier.class.getResourceAsStream("rides.txt");
        Courier courier = new Courier();
        courier.addRide(inputStream);
        assertEquals(75, courier.dailyDistance()[6]);
    }

}