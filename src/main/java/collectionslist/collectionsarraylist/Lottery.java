package collectionslist.collectionsarraylist;

import java.util.*;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < lotteryType) {
            Random rnd = new Random();
            numbers.add(rnd.nextInt(ballCount) + 1);
        }
        List<Integer> selected = new ArrayList<>(numbers);
        Collections.sort(selected);
        return selected;
    }

}
