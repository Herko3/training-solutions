package week12.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodsPackerTest {

    @Test
    void packGoods() {
        GoodsPacker packer = new GoodsPacker();
        int[][] types = {{7, 160}, {3, 90}, {2, 15}};

        assertEquals(555,packer.packGoods(types,20));
    }
}