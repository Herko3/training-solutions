package week07.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    Fibonacci fibonacci = new Fibonacci();

    //a 0. az első szám (0,1,1,2,3,5...)
    @Test
    public void testFib(){
        assertEquals(0,fibonacci.fib(1));
        assertEquals(377,fibonacci.fib(15));
    }

    //az 1. az első szám (1,1,2,3,5...)
    @Test
    public void testFibRec(){
        assertEquals(1,fibonacci.fibRec(1));
        assertEquals(610,fibonacci.fibRec(15));
    }

}