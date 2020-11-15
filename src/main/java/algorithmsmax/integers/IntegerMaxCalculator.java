package algorithmsmax.integers;

import java.util.List;

public class IntegerMaxCalculator {

    public Integer max(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (Integer search : numbers) {
            if (search > max) {
                max = search;
            }
        }
        return max;
    }

}
