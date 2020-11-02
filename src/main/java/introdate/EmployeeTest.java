package introdate;

import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adja meg a nevét!");
        String name = scanner.nextLine();

        System.out.println("Adja meg a születési dátumát! Először az évet számokkal");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Majd a hónapot számokkal");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Végül a napot számokkal");
        int day = scanner.nextInt();
        scanner.nextLine();

        Employee employee = new Employee(year,month,day,name);

        System.out.println("A felvett adatok:");
        System.out.println("Név:" + employee.getName());
        System.out.println("Születési idő:" + employee.getDayOfBirth());
        System.out.println("Belépési idő:" + employee.getBeginEmployement());

    }

}
