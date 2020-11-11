package introexception;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {
        try{
            int value = Integer.parseInt(ssn);
            } catch (NumberFormatException nfe){
            return false;
        }

        if (ssn.length() == 9) {
            int even = 0;
            int odd = 0;
            for (int i = 0; i < 8; i += 2) {
                odd += Integer.parseInt(String.valueOf(ssn.charAt(i)))*3;
            }
            for (int i=1;i<8;i+=2){
                even += Integer.parseInt(String.valueOf(ssn.charAt(i)))*7;
            }
            if((odd+even)/10 == Integer.parseInt(String.valueOf(ssn.charAt(8)))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SsnValidator test = new SsnValidator();
        System.out.println(test.isValidSsn("12345678"));
        System.out.println(test.isValidSsn("123456789"));
        System.out.println(test.isValidSsn("110000001"));
    }

}
