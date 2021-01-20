package week10.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void findMinMaxSum() {
        int[] arr = {1, 3, 5, 7, 9};

        assertEquals(16,new Calculator().findMinMaxSum(arr)[0]);
        assertEquals(24,new Calculator().findMinMaxSum(arr)[1]);
    }
}