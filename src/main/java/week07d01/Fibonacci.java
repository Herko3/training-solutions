package week07d01;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    private static final long[] fibo = new long[1024];

    public long fib(int n) {
        fibo[1] = 1L;
        if (n < 1) {
            throw new IllegalArgumentException("The series starts with an index of 1");
        }
        int index = 1;
        while (index != n) {
            fibo[index + 1] = fibo[index - 1] + fibo[index];
            index++;
        }
        return fibo[n-1];
    }


    public static long fibRec(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Counter must be positive");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (RESULTS[n] == null) {
            RESULTS[n] = fibRec(n - 2) + fibRec(n - 1);
        }

        return RESULTS[n];

    }

    private static final Long[] RESULTS = new Long[1024];


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(4));
        System.out.println(fibonacci.fib(5));
        System.out.println(fibonacci.fib(15));
    }

}
