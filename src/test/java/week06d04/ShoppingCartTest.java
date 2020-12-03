package week06d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    public void testAdd(){
        ShoppingCart sc = new ShoppingCart();
        sc.addItem("sajt",15);

        assertEquals(1,sc.getItems().size());
        assertEquals(15,sc.getItem("sajt"));
    }

    @Test
    public void testAddIfContains(){
        ShoppingCart sc = new ShoppingCart();
        sc.addItem("sajt",15);
        sc.addItem("sajt",15);

        assertEquals(1,sc.getItems().size());
        assertEquals(30,sc.getItem("sajt"));
    }

    @Test
    public void testException(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ShoppingCart().addItem(null,10) );
        assertEquals("Item name must not be empty", ex.getMessage());
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new ShoppingCart().addItem(" ",10) );
        assertEquals("Item name must not be empty", ex1.getMessage());
    }



}