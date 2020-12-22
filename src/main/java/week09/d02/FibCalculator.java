package week09.d02;

public class FibCalculator {

    public long sumEvens(int bound) {
        int first = 0;
        int second = 1;
        int sum = 0;

        while (second < bound) {
            if (second % 2 == 0) {
                sum += second;
            }
            int helper = first + second;
            first = second;
            second = helper;
        }
        return sum;
    }

}
