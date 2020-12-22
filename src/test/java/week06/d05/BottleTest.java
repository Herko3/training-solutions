package week06.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    private Bottle glass = Bottle.of(BottleType.GLASS_BOTTLE);
    private Bottle pet = Bottle.of(BottleType.PET_BOTTLE);

    @Test
    public void testFillGlass(){
        glass.fill(150);
        assertEquals(BottleType.GLASS_BOTTLE,glass.getType());
        assertEquals(150,glass.getFilledUntil());
    }

    @Test
    public void testFillPet(){
        pet.fill(150);
        assertEquals(BottleType.PET_BOTTLE,pet.getType());
        assertEquals(150,pet.getFilledUntil());
    }

    @Test
    public void testException(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> pet.fill(1000));
        assertEquals("The bottle can't hold that much",ex.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> glass.fill(1000));
        assertEquals("The bottle can't hold that much",ex2.getMessage());

    }
}