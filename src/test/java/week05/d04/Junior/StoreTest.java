package week05.d04.Junior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    @Test
    public void testAdd(){
        Store test = new Store();
        test.addProduct(new Product("alma",1992,10,25));

        assertEquals(1,test.getProducts().size());
    }

}
