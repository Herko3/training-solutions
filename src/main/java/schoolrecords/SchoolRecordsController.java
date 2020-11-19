package schoolrecords;


import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords;
    private List<Tutor> tutors;
    private List<Subject> subjects;

    private Scanner scanner = new Scanner(System.in);

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
        int choice = 0;
        try {

            choice = scanner.nextInt();
            scanner.skip("\n");
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
                caseFind();
                break;
            case 3:
                caseAddNew();
                break;
            case 4:
                caseDelete();
                break;
            case 5:
                caseRepetition();
                break;
            case 6:
                caseClassAverage();
                break;
            case 7:
                caseClassAverageBySubject();
                break;
            case 8:
                System.out.println("Diákok átlagai:");
                System.out.println(classRecords.listStudyResults());
                break;
            case 9:
                caseAverageOfStudent();
                break;
            case 10:
                caseAverageOfStudentBySubject();
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
        System.out.println("Folytatáshoz nyomja meg az ENTER-t");
        scanner.nextLine();
        printMenu();
    }

    private void caseFind(){
        System.out.println("Adja meg a keresendő nevet:");
        String name = scanner.nextLine();
        try {
            System.out.println(classRecords.findStudentByName(name));
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    private void caseAddNew(){
        System.out.println("Adja meg az új diák nevét:");
        String name = scanner.nextLine();
        try {
            classRecords.addStudent(new Student(name));
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    private void caseDelete(){
        System.out.println("Törölni kívánt diák neve:");
        String delete = scanner.nextLine();
        try{
            classRecords.removeStudent(classRecords.findStudentByName(delete));
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        } catch (IllegalStateException ise){
            System.out.println(ise.getMessage());
        }
    }

    private void caseRepetition(){
        Student repetition = classRecords.repetition();
        System.out.println(repetition.getName() + " fog felelni!");
        System.out.println("Adja meg a tantárgyat amiből felelni fog:");
        String subject = scanner.nextLine();
        System.out.println("Adja meg a tárgyat tanító nevét:");
        String name = scanner.nextLine();
        System.out.println("Adja meg az érdemjegyet (A/B/C/D/F)");
        String mark = scanner.nextLine();
        repetition.grading(new Mark(MarkType.valueOf(mark), getSubject(subject), getTutor(name)));
    }

    private void caseClassAverage(){
        System.out.println("Az osztály átlaga:");
        try {
            System.out.println(classRecords.calculateClassAverage());
        } catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
        }
    }

    private void caseClassAverageBySubject(){
        System.out.println("Melyik tantárgyra kívánja nézni?");
        String subject = scanner.nextLine();
        System.out.println(classRecords.calculateClassAverageBySubject(getSubject(subject)));
    }

    private void caseAverageOfStudent(){
        System.out.println("Adja meg a diák nevét:");
        String name = scanner.nextLine();
        System.out.println(classRecords.findStudentByName(name).calculateAverage());
    }

    private void caseAverageOfStudentBySubject(){
        System.out.println("Adja meg a diák nevét");
        String name = scanner.nextLine();
        System.out.println("Adja meg a kívánt tantárgyat");
        String subject = scanner.nextLine();
        System.out.println(classRecords.findStudentByName(name).calculateSubjectAverage(getSubject(subject)));
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
