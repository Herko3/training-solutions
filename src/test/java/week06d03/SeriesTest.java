package week06d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {
    Series series = new Series();

    @Test
    public void testException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(null));
        assertEquals("The List must consist at least 2 number", ex.getMessage());
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(new ArrayList<>(Arrays.asList(0))));
        assertEquals("The List must consist at least 2 number", ex2.getMessage());
    }

    @Test
    public void testCalculate() {

        assertEquals(SeriesType.GROWING, series.calculateSeriesType(new ArrayList<>(Arrays.asList(0, 2, 4))));
        assertEquals(SeriesType.RANDOM, series.calculateSeriesType(new ArrayList<>(Arrays.asList(0, 6, 4))));
        assertEquals(SeriesType.RANDOM, series.calculateSeriesType(new ArrayList<>(Arrays.asList(0, -6, 4))));
        assertEquals(SeriesType.DECREASING, series.calculateSeriesType(new ArrayList<>(Arrays.asList(0, -6, -40))));
    }

}