package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adja meg a következő eredményét:\n"+ "4+(5-2)*2/4");
        double answer = scanner.nextDouble();

        double eredmeny = 4+(5-2)*2/4d;
        System.out.println("A beírt eredménye: ");
        System.out.println(Math.abs(eredmeny-answer)<0.0001 ? "Helyes" : "Helytelen");
        System.out.println("A helyes eredmény:" + eredmeny);

    }

}
