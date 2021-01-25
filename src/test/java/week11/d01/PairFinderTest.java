package week11.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void testFindPairs() {
        int[] test = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        assertEquals(4, new PairFinder().findPairs(test));

        int[] test2 = {5, 1, 4, 5};
        assertEquals(1, new PairFinder().findPairs(test2));
    }

}