package schoolrecords;


import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords;
    private List<Tutor> tutors;
    private List<Subject> subjects;

    public void initSchool() {
        subjects = Arrays.asList(new Subject("földrajz"),
                new Subject("matematika"),
                new Subject("biológia"),
                new Subject("zene"),
                new Subject("fizika"),
                new Subject("kémia"));
        tutors = Arrays.asList(new Tutor("Nagy Csilla", subjects));
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
        System.out.printf("Adja meg a választott menüpont számát:");
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
                System.out.println("Az osztály diákjai:");
                System.out.println(classRecords.listStudentNames());
                break;
            case 2:
                System.out.println("Adja meg a keresendő nevet:");
                scanner.skip("\n");
                String name = scanner.nextLine();
                System.out.println(classRecords.findStudentByName(name));
                break;
            case 3:
                System.out.println("Adja meg az új diák nevét:");
                scanner.skip("\n");
                name = scanner.nextLine();
                classRecords.addStudent(new Student(name));
                break;
            case 4:
                System.out.println("Törölni kívánt diák neve:");
                scanner.skip("\n");
                String delete = scanner.nextLine();
                classRecords.removeStudent(classRecords.findStudentByName(delete));
                break;
            case 5:
                System.out.println(classRecords.repetition());
                break;
            case 6:
                System.out.println("Az osztály átlaga:");
                System.out.println(classRecords.calculateClassAverage());
                break;
            case 7:
                System.out.println("Melyik tantárgyra kívánja nézni?");
                String subject = scanner.nextLine();
                System.out.println(classRecords.calculateClassAverageBySubject(getSubject(subject)));
                break;
            case 8:
                System.out.println("Diákok átlagai:");
                System.out.println(classRecords.listStudyResults());
                break;
            case 9:
                System.out.println("Adja meg a diák nevét");
                name = scanner.nextLine();
                System.out.println(classRecords.findStudentByName(name).calculateAverage());
                break;
            case 10:
                System.out.println("Adja meg a diák nevét");
                name = scanner.nextLine();
                System.out.println("Adja meg a kívánt tantárgyat");
                subject = scanner.nextLine();
                System.out.println(classRecords.findStudentByName(name).calculateSubjectAverage(getSubject(subject)));
                break;
            case 11:
                System.exit(0);
            default:
                printMenu();
        }
        cont();
    }

    private void cont() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Folytatáshoz nyomja meg az ENTER-t");
        scanner.nextLine();
        printMenu();
    }

    private Subject getSubject(String subjectName){
        for(Subject all : subjects){
            if(all.getSubjectName().equals(subjectName)){
                return all;
            }
        }
        throw new IllegalArgumentException("Nincs ilyen tárgy");
    }

    private Tutor getTutor(String tutorName){
        for(Tutor all : tutors){
            if(all.getName().equals(tutorName)){
                return all;
            }
        }
        throw new IllegalArgumentException("Nincs ilyen tanár");
    }


    public static void main(String[] args) {
        SchoolRecordsController controller = new SchoolRecordsController();
        controller.initSchool();
        controller.printMenu();
    }

}
