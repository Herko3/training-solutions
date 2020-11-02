package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adjon meg 5 számot");

        int sum = 0;
        for (int i=0;i<5;i++){
            System.out.println("Add meg a " + (i+1) + ". számot");
            int number = scanner.nextInt();
            scanner.nextLine();

            sum = sum + number;
        }
        System.out.println("Az összeg: " + sum);
    }
}
