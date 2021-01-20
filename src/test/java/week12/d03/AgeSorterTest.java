package week12.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeSorterTest {

    @Test
    void sortAges() {
        AgeSorter ageSorter = new AgeSorter();
        int[] sort = {2,3,1,2,4,6};
        int[] expected = {1,2,2,3,4,6};
        assertArrayEquals(expected,ageSorter.sortAges(sort));
    }
}