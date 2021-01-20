package week12.d03;

import java.util.ArrayList;
import java.util.List;

public class AgeSorter {

    public int[] sortAges(int[] ages) {
        int[] sorted = new int[ages.length];
        List<Integer> agesList = arrayToList(ages);
        agesList = sortList(agesList);
        for (int i = 0; i < agesList.size(); i++) {
            sorted[i] = agesList.get(i);
        }
        return sorted;
    }

    private List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    private List<Integer> sortList(List<Integer> toSort) {
        List<Integer> sorted = new ArrayList<>();
        while (!toSort.isEmpty()) {
            Integer min = Integer.MAX_VALUE;
            for (int i : toSort) {
                if (i < min) {
                    min = i;
                }
            }
            sorted.add(min);
            toSort.remove(min);
        }
        return sorted;
    }

}
