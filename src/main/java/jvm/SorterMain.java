package jvm;

import java.util.List;
import java.util.Random;

public class SorterMain {

    public static void main(String[] args) {
        while(true){
            Random rnd = new Random();
            int size = rnd.nextInt(500_000);
            System.out.println("Creating and sorting list with size " + size);
            List<Integer> list = new Sorter().createListAndSort(size);
        }
    }
}
