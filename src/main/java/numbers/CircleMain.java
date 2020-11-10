package numbers;

import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adjon meg 2db kör átmérőt\nAdja meg az elsőt:");
        int elso = Integer.parseInt(scanner.nextLine());
        System.out.println("Adja meg a másodikat");
        int masodik = Integer.parseInt(scanner.nextLine());
       Circle kor1 = new Circle(elso);
       Circle kor2 = new Circle(masodik);

        System.out.println("Az első átmérője: " + elso + ", kerülete: " + kor1.perimeter() + ", területe: " + kor1.area());
        System.out.println("A második átmérője: " + masodik + ", kerülete: " + kor2.perimeter() + ", területe: " + kor2.area());


    }

}
