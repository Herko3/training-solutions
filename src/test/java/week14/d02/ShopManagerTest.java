package week14.d02;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopManagerTest {

    private ShopManager test = new ShopManager();
    BufferedReader reader = new BufferedReader(new InputStreamReader(ShopManager.class.getResourceAsStream("shoppinglist.txt")));

    @Test
    void testGetPriceByShopper() {
        test.readFile(reader);

        assertEquals(4890, test.getPriceByShopper("BK123"));

    }

    @Test
    void testGetPriceById() {
        test.readFile(reader);

        assertEquals(640, test.getPriceById("1211"));
    }

    @Test
    void testSorted() {
        test.readFile(reader);

        assertEquals("bread", test.sortedBy("BK123", "1211", Comparator.comparing(Product::getName)).get(0).getName());
        assertEquals(320, test.sortedBy("BK123", "1211", Comparator.comparing(Product::getName)).get(1).getPrice());

        assertEquals("soda", test.sortedBy("BK123", "1211", Comparator.comparing(Product::getPrice)).get(0).getName());
        assertEquals(200, test.sortedBy("BK123", "1211", Comparator.comparing(Product::getPrice)).get(1).getPrice());
    }

    @Test
    void testNumberBought(){
        test.readFile(reader);

        assertEquals(3,test.numberBought("tomato"));
        assertEquals(1,test.numberBought("sugar"));
    }

    @Test
    void testStatistics(){
        test.readFile(reader);

        Map<String, Long> statistics = test.statistics();

        assertEquals(2,statistics.get("corn"));
        assertEquals(1,statistics.get("Nutella"));

        assertTrue(statistics.containsKey("jam"));
        assertTrue(statistics.containsKey("salt"));

        System.out.println(statistics.entrySet());
    }

}