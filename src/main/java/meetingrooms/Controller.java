package meetingrooms;


import java.util.Scanner;

public class Controller {

    private Office office = new Office();

    public void readOffice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mennyi tárgyalót akar felvenni?");
        int numberOfMeetingRooms = scanner.nextInt();
        scanner.nextLine();
        String name;
        int length;
        int width;
        for (int i = 0; i < numberOfMeetingRooms; i++) {
            System.out.println("Adja meg a(z) " + (i + 1) + ". tárgyaló nevét");
            name = scanner.nextLine();
            System.out.println("Adja meg a(z) " + (i + 1) + ". tárgyaló hosszúságát méterben");
            length = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Adja meg a(z) " + (i + 1) + ". tárgyaló szélességét méterben");
            width = scanner.nextInt();
            scanner.nextLine();
            office.addMeetingRoom(new MeetingRoom(name, length, width));
        }
        printMenu();
    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
        runMenu();
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            office.printNames();
            System.out.println("Visszatéréshez nyomjon ENTER-t");
            scanner.nextLine();
            printMenu();
        }
        if (choice == 2) {
            office.printNamesReverse();
            System.out.println("Visszatéréshez nyomjon ENTER-t");
            scanner.nextLine();
            printMenu();
        }
        if (choice == 3) {
            office.printEvenNames();
            System.out.println("Visszatéréshez nyomjon ENTER-t");
            scanner.nextLine();
            printMenu();
        }
        if (choice == 4) {
            office.printAreas();
            System.out.println("Visszatéréshez nyomjon ENTER-t");
            scanner.nextLine();
            printMenu();
        }
        if (choice == 5) {
            System.out.println("Tárgyaló neve?");
            office.printMeetingRoomsWithName(scanner.nextLine());
            System.out.println("Visszatéréshez nyomjon ENTER-t");
            scanner.nextLine();
            printMenu();
        }
        if (choice == 6) {
            System.out.println("Az összes ezt tartalmazó tárgyalót kilistázzuk? <y/n>");
            if (scanner.nextLine().equals("y")) {
                System.out.println("Keresendő kifejezés?");
                office.printMeetingRoomsContains(scanner.nextLine());
                System.out.println("Visszatéréshez nyomjon ENTER-t");
                scanner.nextLine();
                printMenu();
            } else {
                System.out.println("Keresendő kifejezés?");
                office.printMeetingRoomsFirstContains(scanner.nextLine());
                System.out.println("Visszatéréshez nyomjon ENTER-t");
                scanner.nextLine();
                printMenu();
            }
        }
        if (choice == 7) {
            System.out.println("A keresendő terület mérete?");
            office.printAreasLargerThan(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Visszatéréshez nyomjon ENTER-t");
            scanner.nextLine();
            printMenu();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readOffice();

    }


}
