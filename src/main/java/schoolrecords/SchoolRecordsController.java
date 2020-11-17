package schoolrecords;


import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords;
    private Tutor tutor;
    private List<Subject> subjects;

    public void initSchool() {
        subjects = Arrays.asList(new Subject("földrajz"),
                new Subject("matematika"),
                new Subject("biológia"),
                new Subject("zene"),
                new Subject("fizika"),
                new Subject("kémia"));
        tutor = new Tutor("Nagy Csilla", subjects);
        classRecords = new ClassRecords("Fourth Grade A", new Random());
    }

    public void printMenu() {
        System.out.println(
                "1. Diákok nevének listázása\n" +
                        "2. Diák név alapján keresése\n" +
                        "3. Diák létrehozása\n" +
                        "4. Diák név alapján törlése\n" +
                        "5. Diák feleltetése\n" +
                        "6. Osztályátlag kiszámolása\n" +
                        "7. Tantárgyi átlag kiszámolása\n" +
                        "8. Diákok átlagának megjelenítése\n" +
                        "9. Diák átlagának kiírása\n" +
                        "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                        "11. Kilépés");
        runMenu();
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try {

            choice = scanner.nextInt();

        } catch (InputMismatchException ex) {
            System.out.println("Csak számokat írjon be");
            cont();
        }

        switch (choice) {
            case 1:
                System.out.println(classRecords.listStudentNames());
                cont();
            case 2:
                System.out.println("Adja meg a keresendő nevet:");
                scanner.skip("\n");
                String name = scanner.nextLine();
                System.out.println(classRecords.findStudentByName(name));
                cont();
            case 3:
                System.out.println("Adja meg az új diák nevét:");
                scanner.skip("\n");
                String addName = scanner.nextLine();
                classRecords.addStudent(new Student(addName));
                cont();
            case 4:
                System.out.println("Törölni kívánt diák neve:");
                scanner.skip("\n");
                String delete = scanner.nextLine();
                classRecords.removeStudent(classRecords.findStudentByName(delete));
                cont();
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                System.exit(0);
            default:
                printMenu();
        }

    }

    public void cont() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Folytatáshoz nyomja meg az ENTER-t");
        scanner.nextLine();
        printMenu();
    }


    public static void main(String[] args) {
        SchoolRecordsController controller = new SchoolRecordsController();
        controller.initSchool();
        controller.printMenu();
    }

}
