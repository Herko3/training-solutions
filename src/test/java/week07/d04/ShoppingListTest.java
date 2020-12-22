package week07.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    @Test
    public void testSum(){
        ShoppingList shoppingList = new ShoppingList();

        assertEquals(120L,shoppingList.calculateSum("src/main/resources/week07d04/Shop"));
    }

}