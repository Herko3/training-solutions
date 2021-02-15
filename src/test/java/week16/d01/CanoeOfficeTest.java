package week16.d01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CanoeOfficeTest {

    CanoeOffice office;

    @BeforeEach
    void setUp() {
        office = new CanoeOffice();
        office.createRental(new CanoeRental("Rental 1", CanoeType.RED, "2021-02-15T14:30"));
        office.createRental(new CanoeRental("Rental 2", CanoeType.BLUE, "2021-02-15T15:30"));
        office.createRental(new CanoeRental("Rental 3", CanoeType.RED, "2021-02-15T14:30"));
        office.createRental(new CanoeRental("Rental 4", CanoeType.GREEN, "2021-02-15T12:30"));
        office.createRental(new CanoeRental("Rental 5", CanoeType.BLUE, "2021-02-15T16:30"));
        office.createRental(new CanoeRental("Rental 6", CanoeType.GREEN, "2021-02-15T11:30"));
    }

    @AfterEach
    void delete() {
        office = null;
    }

    @Test
    void testCreate() {
        office.createRental(new CanoeRental("Rental 7", CanoeType.RED, "2021-02-15T11:30"));
        assertEquals(7, office.getRentals().size());
    }

    @Test
    void testEndRentalThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> office.closeRentalByName("Rental 2", LocalDateTime.parse("2021-02-15T11:30")));
    }

    @Test
    void testEndRental(){
        CanoeRental result = office.findRentalByName("Rental 2");
        office.closeRentalByName("Rental 2", LocalDateTime.parse("2021-02-15T16:30"));

        assertTrue(result.isDone());
    }

    @Test
    void findRental(){
        CanoeRental rental = office.findRentalByName("Rental 3");
        assertEquals(CanoeType.RED,rental.getCanoeType());
    }

    @Test
    void testCollectEnded(){
        office.closeRentalByName("Rental 2", LocalDateTime.parse("2021-02-15T16:30"));
        office.closeRentalByName("Rental 4", LocalDateTime.parse("2021-02-15T16:30"));
        List<CanoeRental> result = office.listClosedRentals();

        assertEquals(2,result.size());
        assertEquals("Rental 4",result.get(0).getName());
    }

    @Test
    void testPrice(){

        assertEquals(5000,office.getRentalPriceByName("Rental 1",LocalDateTime.parse("2021-02-15T15:30")));
        assertEquals(15000,office.getRentalPriceByName("Rental 2",LocalDateTime.parse("2021-02-15T16:31")));
        assertEquals(18000,office.getRentalPriceByName("Rental 4",LocalDateTime.parse("2021-02-15T15:30")));
    }

    @Test
    void tesMap(){
        Map<CanoeType,Long> result = office.countRentals();

        assertEquals(2,result.get(CanoeType.RED));
    }

}