package week15.d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BitcoinBuyTest {

    @Test
    public void testBestRateCalculator(){
        List<Integer> rates = Arrays.asList(100,120,40,70,200,30,50);

        assertEquals(160,new BitcoinBuy().calculator(rates).getDiff());
    }

}