package covid;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Scanner scanner = new Scanner(System.in);
    private RegistrationDao dao;

    public Controller(DataSource dataSource) {
        dao = new RegistrationDao(dataSource);
    }

    private void printMenu() {
        System.out.println(
                "1. Regisztráció \n" +
                        "2. Tömeges regisztráció \n" +
                        "3. Generálás \n" +
                        "4. Oltás \n" +
                        "5. Oltás meghiúsulás \n" +
                        "6. Riport \n" +
                        "7. Kilépés");
        runMenu();
    }

    private void runMenu() {
        System.out.printf("Adja meg a választott menüpont számát:");
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException ex) {
            System.out.println("Csak számokat írjon be");
            cont();
        }
        switch (choice) {
            case 1 -> registration();
            case 2 -> massRegistration();
            case 3 -> generateFile();
            case 4 -> System.out.println("not done yet");
            case 5 -> System.out.println("not done yet");
            case 6 -> System.out.println("not done yet");
            case 7 -> System.exit(0);
            default -> {
                System.out.println("Ilyen menüpont nem létezik, válasszon másikat!");
                printMenu();
            }
        }
        cont();
    }

    private void generateFile() {
        System.out.println("Adja meg a fájl nevét!");
        String fileName = scanner.nextLine();
        System.out.println("Adja meg a kívánt irányítószámot!");
        String zip = readValidZip();
        List<Citizen> filtered = dao.getCitizenListBy(zip, LocalDate.now());
        new PrintFile().saveToFile(filtered,fileName);
        System.out.println("Sikeres generálás!");

    }

    private void cont() {
        System.out.println("Folytatáshoz nyomja meg az ENTER-t");
        scanner.nextLine();
        printMenu();
    }

    private void registration() {
        String name = readValidName();
        String zip = readValidZip();
        int age = readValidAge();
        String email = readValidEmail();
        String ssn = readValidSsn();
        dao.insertCitizen(new Citizen(name,zip,age,email,ssn));
    }

    private String readValidSsn() {
        System.out.println("Adja meg taj számát:");
        String ssn = scanner.nextLine();
        if(Validator.isInvalidSsn(ssn)){
            System.out.println("Nem érvényes taj szám");
            ssn = readValidSsn();
        }
        return ssn;
    }

    private String readValidEmail() {
        System.out.println("Adja meg email-címét:");
        String email = scanner.nextLine();
        if (Validator.isInvalidEmail(email)) {
            System.out.println("Email-cím nem megfelelő!");
            email = readValidEmail();
        }
        return email;
    }

    private String readValidZip() {
        System.out.println("Adja meg az irányítószámát:");
        String zip = scanner.nextLine();
        if (Validator.isInvalidZip(zip)) {
            System.out.println("Adjon meg igazi irányítószámot!");
            zip = readValidZip();
        }
        try {
            System.out.println("Az irányítószámhoz tartozó város: " + dao.findCityByZip(zip));
        } catch(IllegalArgumentException iae){
            System.out.println("Ilyen irányítószámmal nincs város az adatbázisunkban!");
            return readValidZip();
        }
        return zip;
    }

    private String readValidName() {
        System.out.println("Adja meg a nevét:");
        String name = scanner.nextLine();
        if (Validator.isInvalidName(name)) {
            System.out.println("Ez nem egy név!");
            name = readValidName();
        }
        return name;
    }

    private int readValidAge() {
        System.out.println("Adja meg a korát:");
        try {
            int age = Integer.parseInt(scanner.nextLine());
            if (Validator.isInvalidAge(age)) {
                System.out.println("Nem megfelelő életkor!");
                age = readValidAge();
            }
            return age;
        } catch (NumberFormatException nfe) {
            System.out.println("Ez nem egy szám!");
            return readValidAge();
        }
    }

    private void massRegistration() {
        System.out.println("Adja meg a fájl helyét:");
        String filePath = scanner.nextLine();
        dao.insertCitizensFromFile(filePath);
        System.out.println("Importálás sikeres!");
    }

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid_vaccination?useUnicode=true");
            dataSource.setUser("covid_vaccination");
            dataSource.setPassword("covid_vaccination");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }

        Controller controller = new Controller(dataSource);
        controller.printMenu();

    }
}
