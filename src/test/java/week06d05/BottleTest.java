package week06d05;

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
}