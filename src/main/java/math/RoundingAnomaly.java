package math;

import java.util.Random;

public class RoundingAnomaly {

    private static final Random random = new Random();

    public double [] randomNumbers(int size,double max, int scale){
        double [] numbers = new double[size];
        double factor = Math.pow(10,scale);
        for(int i =0;i<size;i++){
            double number = Math.round(random.nextDouble()*max*factor)/factor;
            numbers[i]=number;
        }
        return numbers;
    }

    public double roundAfterSum(double[] numbers){
        double sum=0;
        for (double ertek:numbers){
            sum+=ertek;
        }
        return Math.round(sum);
    }

    public double sumAfterRound(double[] numbers){
        double sum=0;
        for (double ertek : numbers){
            sum += Math.round(ertek);
        }
        return sum;
    }

    public double difference(int size,double max, int scale){
        double[] numbers = randomNumbers(size,max,scale);
        double resultAfterSum = roundAfterSum(numbers);
        double resultAfterRound = sumAfterRound(numbers);
        return Math.abs(resultAfterRound-resultAfterSum);
    }

    public static void main(String[] args) {
        RoundingAnomaly test = new RoundingAnomaly();
        int count = 100;
        double sum = 0;
        for(int i=0;i<count;i++){
            double diff = test.difference(1000,1_000_000,5);
            sum += diff;
            System.out.println("A(z) " + (i+1) + ". generált tömb 2 metódusának differenciálja: " + diff);
        }
        System.out.println("Az összes tömb differenciáljának átlaga: " + sum/count);
    }

}
