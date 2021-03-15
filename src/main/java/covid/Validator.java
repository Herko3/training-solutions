package covid;

public class Validator {

    public static boolean isInvalidName(String name) {
        return name == null || name.isBlank();
    }

    public static boolean isInvalidZip(String zip) {
        try{
            Integer.parseInt(zip);
        } catch(NumberFormatException nfe){
            return true;
        }
        return zip.isBlank();
    }

    public static boolean isInvalidAge(int age) {
        return age < 10 || age > 150;
    }

    public static boolean isInvalidEmail(String email) {
        return email == null || !email.contains("@") || email.length() < 3;
    }

    public static boolean sameEmail(String email, String email2) {
        return email.equals(email2);
    }

    public static boolean isInvalidSsn(String ssn) {
        if (ssn.length() != 9) {
            return true;
        }
        int sum = 0;
        try {
            for (int i = 0; i < 8; i++) {
                int number = Integer.parseInt(ssn.substring(i, i + 1));
                if (i % 2 == 0) {
                    sum += number * 3;
                } else {
                    sum += number * 7;
                }
            }
                if (sum % 10 == Integer.parseInt(ssn.substring(8))) {
                    return false;
                }
        } catch (NumberFormatException nfe) {
            return true;
        }
        return true;
    }

}
