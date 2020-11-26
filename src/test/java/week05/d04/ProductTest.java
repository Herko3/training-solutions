package week05.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testConvert() {
        assertEquals(0.5,new Product(150,Currency.HUF).convertPrice(Currency.USD));
        assertEquals(150,new Product(150,Currency.HUF).convertPrice(Currency.HUF));
        assertEquals(150,new Product(150,Currency.USD).convertPrice(Currency.USD));
        assertEquals(300,new Product(1,Currency.USD).convertPrice(Currency.HUF));
    }

}
