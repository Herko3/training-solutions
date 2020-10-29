package classstructureio;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {

        System.out.println("Adjon meg egy egész számot!");
        Scanner scanner = new Scanner (System.in);
        int elso = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Köszönöm! Most adjon meg még egyet!");
        int masodik = scanner.nextInt();
        scanner.nextLine();
        System.out.println(elso + "+" + masodik);
        System.out.println(elso + masodik);
    }

}
