package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Duplicates {

    public List<Integer> findDuplicates(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) == (numbers.get(i + 1))) {
                if (result.contains(numbers.get(i))) {
                    continue;
                }
                result.add(numbers.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Duplicates test = new Duplicates();
        System.out.println(test.findDuplicates(Arrays.asList(1, 2, 3, 4, 5, 1, 2, 1)));
    }
}
