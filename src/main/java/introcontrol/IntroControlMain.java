package introcontrol;

import java.util.Scanner;

public class IntroControlMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adjon meg egy számot!");
        IntroControl test = new IntroControl();
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.println(test.substractTenIfGreaterThanTen(number));
        System.out.println(test.describeNumber(number));
        System.out.println("neve?");
        String name = scanner.nextLine();
        System.out.println(test.greetingToJoe(name));
        System.out.println("Eladás összege?");
        System.out.println(test.calculateBonus(scanner.nextInt()));
        test.printNumbers(number);
        test.printOddNumbers(number);
        test.printNumbersBetween(9,15);
        test.printNumbersBetweenAnyDirection(3,6);
        test.printNumbersBetweenAnyDirection(6,3);
    }
}
