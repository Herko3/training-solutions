package week11.d01;

import java.util.Arrays;

public class PairFinder {

    public int findPairs(int[] arr) {
        int pairs = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                pairs++;
                i++;
            }
        }
        return pairs;
    }

}
