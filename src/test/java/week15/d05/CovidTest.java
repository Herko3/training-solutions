package week15.d05;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CovidTest {

    @Test
    void test(){
        InputStream is = Covid.class.getResourceAsStream("data.csv");
        Covid covid = new Covid();
        covid.readFromFile(is);

        assertEquals("Andorra",covid.getMostCasePerPopulation(3).get(0).getName());
        assertEquals(33706,covid.getMostCasePerPopulation(3).get(1).getPopulation());
        assertEquals(65227,covid.getMostCasePerPopulation(3).get(2).getCases());
    }

}