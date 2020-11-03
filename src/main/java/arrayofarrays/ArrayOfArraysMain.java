package arrayofarrays;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size) {
        int[][] tabla = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tabla[i][j] = (i + 1) * (j + 1);
            }
        }

        return tabla;
    }


    public void printArrayOfArrays(int[][] a) {
        for (int[] i : a) {
            for (int j : i) {
                if (j < 10) {
                    System.out.print("  ");
                } else if (j < 100) {
                    System.out.print(" ");
                }
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public int[][] triangularMatrix(int size) {
        int[][] haromszog = new int[size][];
        for (int i = 0; i < size; i++) {
            haromszog[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                haromszog[i][j] = i;
            }
        }
        return haromszog;
    }


    public int[][] getValues(){
        int[][] value = new int[12][];
        int [] napok = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=0;i<napok.length;i++){
          value[i]= new int [napok[i]];
        }

        return value;
    }

    public static void main(String[] args) {
        ArrayOfArraysMain array = new ArrayOfArraysMain();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adjon meg egy számot");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println("szorzótábla");
        array.printArrayOfArrays(array.multiplicationTable(size));
        System.out.println("3szög");
        array.printArrayOfArrays(array.triangularMatrix(size));
        System.out.println("év/nap érték");
        array.printArrayOfArrays(array.getValues());
    }
}
