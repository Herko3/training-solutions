package week08.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryStatisticsTest {

    CountryStatistics stats = new CountryStatistics();

    @Test
    public void testMaxPopulation(){
        stats.init("countries.txt");

        assertEquals("Kongoi_Demokratikus_Koztarsasag 79 3 9",stats.maxPopulation());
    }

    @Test
    public void testInit(){
        stats.init("countries.txt");

        assertEquals(11,stats.getStatistics().size());
    }

}