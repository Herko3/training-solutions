package week10.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    @Test
    public void testMethod(){
        HikingFile hf = new HikingFile();
        Hiking test = hf.getElevation("elevation.txt");
        assertEquals(20,test.getDescend());
        assertEquals(40,test.getAscend());
    }

}