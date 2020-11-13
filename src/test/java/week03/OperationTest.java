package week03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    public void testGetResult(){

        assertEquals(179,new Operation("161+18").getResult());
    }

}
