package week09.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibCalculatorTest {

    FibCalculator fib = new FibCalculator();

    @Test
    public void testSumEvens(){
        assertEquals(0,fib.sumEvens(1));
        assertEquals(2,fib.sumEvens(3));
        assertEquals(2,fib.sumEvens(4));
        assertEquals(2,fib.sumEvens(4));
        assertEquals(10,fib.sumEvens(9));

    }

}