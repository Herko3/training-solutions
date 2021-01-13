package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
        }
        Queue<Integer> numbers = new LinkedList<>(createBallPool(maxNumber));
        while (numbers.size() > drawCount) {
            numbers.poll();
        }
        return new TreeSet<>(numbers);
    }

    private List<Integer> createBallPool(int balls) {
        List<Integer> ballPool = new LinkedList<>();
        for (int i = 1; i <= balls; i++) {
            ballPool.add(i);
        }
        Collections.shuffle(ballPool);
        return ballPool;
    }
}
