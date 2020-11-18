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
        String name = "";
        switch (choice) {
            case 1:
                System.out.println("Az osztály diákjai:");
                System.out.println(classRecords.listStudentNames());
                break;
            case 2:
                System.out.println("Adja meg a keresendő nevet:");
                scanner.skip("\n");
                name = scanner.nextLine();
                try {
                    System.out.println(classRecords.findStudentByName(name));
                } catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                } catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }
                break;
            case 3:
                System.out.println("Adja meg az új diák nevét:");
                scanner.skip("\n");
                name = scanner.nextLine();
                try {
                    classRecords.addStudent(new Student(name));
                } catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }
                break;
            case 4:
                System.out.println("Törölni kívánt diák neve:");
                scanner.skip("\n");
                String delete = scanner.nextLine();
                try{
                    classRecords.removeStudent(classRecords.findStudentByName(delete));
                } catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                } catch (IllegalStateException ise){
                    System.out.println(ise.getMessage());
                }
                break;
            case 5:
                Student repetition = classRecords.repetition();
                System.out.println(repetition.getName() + " fog felelni!");
                System.out.println("Adja meg a tantárgyat amiből felelni fog:");
                scanner.skip("\n");
                String subject = scanner.nextLine();
                System.out.println("Adja meg a tárgyat tanító nevét:");
                name = scanner.nextLine();
                System.out.println("Adja meg az érdemjegyet (A/B/C/D/F)");
                String mark = scanner.nextLine();
                repetition.grading(new Mark(MarkType.valueOf(mark), getSubject(subject), getTutor(name)));
                break;
            case 6:
                System.out.println("Az osztály átlaga:");
                System.out.println(classRecords.calculateClassAverage());
                break;
            case 7:
                System.out.println("Melyik tantárgyra kívánja nézni?");
                scanner.skip("\n");
                subject = scanner.nextLine();
                System.out.println(classRecords.calculateClassAverageBySubject(getSubject(subject)));
                break;
            case 8:
                System.out.println("Diákok átlagai:");
                System.out.println(classRecords.listStudyResults());
                break;
            case 9:
                System.out.println("Adja meg a diák nevét:");
                scanner.skip("\n");
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
                break;
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

    private Subject getSubject(String subjectName) {
        for (Subject all : subjects) {
            if (all.getSubjectName().equalsIgnoreCase(subjectName)) {
                return all;
            }
        }
        System.out.println("Nincs ilyen tárgy");
        cont();
        return null;
    }

    private Tutor getTutor(String tutorName) {
        for (Tutor all : tutors) {
            if (all.getName().equalsIgnoreCase(tutorName)) {
                return all;
            }
        }
        System.out.println("Nincs ilyen nevű tanár");
        cont();
        return null;
    }


    public static void main(String[] args) {
        SchoolRecordsController controller = new SchoolRecordsController();
        controller.initSchool();
        controller.printMenu();
    }

}
