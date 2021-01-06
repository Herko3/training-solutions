package exam02;

import java.util.ArrayList;
import java.util.List;

public class ArraySelector {

    public String selectEvens(int[] array) {
        if (array.length == 0) {
            return "";
        }

        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                evens.add(array[i]);
            }
        }
        return evens.toString();
    }
}
