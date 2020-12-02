package week06d03;

import java.util.List;

public class Series {

    public SeriesType calculateSeriesType(List<Integer> numbers) {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("The List must consist at least 2 number");
        }
        if (numbers.get(0) < numbers.get(1)) {
            return ifBigger(numbers);
        }
        return ifLower(numbers);
    }

    private SeriesType ifBigger(List<Integer> numbers) {
        int first = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > first) {
                first = number;
            } else {
                return SeriesType.RANDOM;
            }
        }
        return SeriesType.GROWING;
    }

    private SeriesType ifLower(List<Integer> numbers) {
        int first = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < first) {
                first = number;
            } else {
                return SeriesType.RANDOM;
            }
        }
        return SeriesType.DECREASING;
    }

}
