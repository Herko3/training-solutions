package week04;

import java.util.Scanner;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {
        if (fullName == null || fullName.trim().equals("")) {
            throw new IllegalArgumentException("Invalid name: " + fullName);
        }
        this.fullName = fullName;
    }

    public String changeFirstName(String firstName) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(fullName);
        String vezetek = scanner.next();
        sb.append(vezetek + " " + firstName);
        return sb.toString();
    }

}
