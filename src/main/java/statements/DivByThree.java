package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adjon meg egy számot");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println(number % 3 == 0 ? "3-mal osztható" : "3-mal nem osztható");

    }

}
