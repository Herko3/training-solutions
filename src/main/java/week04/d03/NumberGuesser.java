package week04.d03;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {

        int toGuess = new Random().nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tippelje meg a számot");
        int guess = Integer.parseInt(scanner.nextLine());
        int numberOfGuesses = 0;
        while (numberOfGuesses != 7 && guess!=toGuess) {

            if (toGuess > guess) {
                System.out.println("A gondolt szám nagyobb!");
                numberOfGuesses++;
            }

            if (toGuess < guess) {
                System.out.println("A gondolt szam kisebb");
                numberOfGuesses++;
            }
            guess = Integer.parseInt(scanner.nextLine());
        }
        if(toGuess==guess) {
            System.out.println("Gratulálok eltaláltad!");
        }
        if(numberOfGuesses==7){
            System.out.println("Ön vesztett!");
        }
    }
}

