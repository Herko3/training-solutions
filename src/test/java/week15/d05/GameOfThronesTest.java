package week15.d05;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameOfThronesTest {

    @Test
    void test(){
        InputStream is = GameOfThrones.class.getResourceAsStream("battles.csv");
        GameOfThrones GOT = new GameOfThrones();
        List<Houses> result = GOT.count(is);

        assertEquals(21,result.size());
        assertEquals("Lannister",result.get(0).getName());
    }

}