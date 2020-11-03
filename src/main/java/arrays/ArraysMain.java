package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return Arrays.toString(numberOfDays);
    }

    public List<String> daysOfWeek() {
        return Arrays.asList("hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap");

    }

    public String multiplicationTableAsString(int size) {
        int[][] tabla = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tabla[i][j] = (i + 1) * (j + 1);
            }
        }

        return Arrays.deepToString(tabla);
    }


    public boolean sameTempValues(double[] day, double[] anotherday){

        return Arrays.equals(day,anotherday);
    }

    public boolean wonLottery(int[] megtett ,int[] kihuzott){
        Arrays.sort(megtett);
        Arrays.sort(kihuzott);
        return Arrays.equals(megtett,kihuzott);
//        return Arrays.equals(Arrays.sort(megtett),Arrays.sort(kihuzott)); nem jo
    }

    public static void main(String[] args) {
        ArraysMain array = new ArraysMain();
        System.out.println("nap/hónap");
        System.out.println(array.numberOfDaysAsString());
        System.out.println("nap nevek");
        System.out.println(array.daysOfWeek());
        System.out.println("szorzó");
        System.out.println(array.multiplicationTableAsString(6));
        System.out.println("sametemp");
        System.out.println(array.sameTempValues(new double[] {3,8,9},new double[] {3,8,9}));
        System.out.println(array.sameTempValues(new double[] {3,8,9},new double[] {3,8,10}));
        System.out.println("lotto");
        System.out.println(array.wonLottery(new int[] {12,15,18,23},new int[] {23,18,12,15}));
        System.out.println(array.wonLottery(new int[] {12,15,18,23},new int[] {23,18,13,15}));
    }
}
