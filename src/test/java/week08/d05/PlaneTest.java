package week08.d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    Path file = Path.of("src/main/resources/week08.d05/map.txt");

    @Test
    public void testMethod(){
        Plane plane = new Plane();
        assertEquals(16,plane.longestOcean(file));
    }

}