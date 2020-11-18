package week04;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {


//    public List<Integer> getFibonacci (int howLong){
//        int number = 1;
//        List<Integer> fibonacci =new ArrayList<>();
//        fibonacci.add(1);
//        while (number!=howLong) {
//            if (number == 1 || number == 2) {
//                fibonacci.add(1);
//            } else {
//                int size = fibonacci.size();
//                fibonacci.add(fibonacci.get(size - 1) + fibonacci.get(size - 2));
//                number++;
//                return fibonacci;
//            }
//        }
//        return fibonacci;
//    }

    public int getFibonacci(int n){
        if(n<=1){
            return n;
        }else{
            return getFibonacci(n-1)+getFibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        test.getFibonacci(10);
        System.out.println(test.getFibonacci(5));
    }

}
