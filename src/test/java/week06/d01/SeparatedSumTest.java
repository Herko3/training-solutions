package week06.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    @Test
    void testSum(){
        SeparatedSum separatedSum = new SeparatedSum();
        SumResults result = separatedSum.sum("56,67;6,8;3;-12;-16,7");

        assertEquals(66.47,result.getPositive(),0.005);
        assertEquals(-28.7,result.getNegative(),0.005);
    }

}