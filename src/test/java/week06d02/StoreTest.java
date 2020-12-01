package week06d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store = new Store(Arrays.asList(
            new Product("alma",Category.OTHER,150),
            new Product("kenyér",Category.BAKEDGOODS,150),
            new Product("sajt",Category.DAIRY,150),
            new Product("tej",Category.DAIRY,150),
            new Product("gesztenye",Category.FROZEN,150)
    ));

    @Test
    public void test(){
        assertEquals(2,store.getProductsByCategory().getNumberOfDairy());
        assertEquals(1,store.getProductsByCategory().getNumberOfFrozen());
        assertEquals(1,store.getProductsByCategory().getNumberOfOther());
        assertEquals(1,store.getProductsByCategory().getNumberOfBakedgoods());
    }


}