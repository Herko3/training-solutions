package week10.d05;

import java.util.Arrays;

public class Calculator {

    public int[] findMinMaxSum(int[] arr) {
        Arrays.sort(arr);
        if (arr.length < 4) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return new int[]{sum, sum};
        }
        return new int[]{minSum(arr), maxSum(arr)};
    }

    private int minSum(int[] arr) {
        int sum = 0;
        int[] min = Arrays.copyOfRange(arr, 0, 4);
        for (int i : min) {
            sum += i;
        }
        return sum;
    }

    private int maxSum(int[] arr) {
        int sum = 0;
        int[] max = Arrays.copyOfRange(arr, arr.length - 4, arr.length);
        for (int i : max) {
            sum += i;
        }
        return sum;
    }
}
