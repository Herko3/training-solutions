package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {

        int toGuess = new Random().nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tippelje meg a számot");
        int guess = Integer.parseInt(scanner.nextLine());

        while (guess!=toGuess) {

            if (toGuess > guess) {
                System.out.println("A gondolt szám nagyobb!");
            }

            if (toGuess < guess) {
                System.out.println("A gondolt szam kisebb");
            }
            guess = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Gratulálok eltaláltad!");
    }
}

