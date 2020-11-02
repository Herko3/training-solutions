package stringtype.registration;

import java.util.Scanner;

public class Registation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adja meg az új felhasználónevet");
        String username = scanner.nextLine();
        System.out.println("Adja meg a jelszavát");
        String password1 = scanner.nextLine();
        System.out.println("Adja meg a ismét");
        String password2 = scanner.nextLine();
        System.out.println("Adja meg az email címét");
        String email = scanner.nextLine();

        UserValidator validate = new UserValidator(username,password1,password2,email);

        System.out.println(validate.isValidUsername(username) ? "Felhasználó neve: megfelelő" : "Felhasználó neve: nem megfelelő");
        System.out.println(validate.isValidPassword(password1,password2) ? "Jelszava: megfelelő" : "Jelszava: nem megfelelő");
        System.out.println(validate.isValidEmail(email) ? "Email címe: megfelelő" : "Email címe nem megfelelő" );

    }
}
