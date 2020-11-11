package introexception;

public class Patient {

    private static final int MIN_YEAR = 1900;


    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String ssn, int yearOfBirth) {
        if(yearOfBirth<= MIN_YEAR){
            throw new IllegalArgumentException("Invalid year of birth: " + yearOfBirth);
        }
        if(name == ""){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(new SsnValidator().isValidSsn(ssn)){
            throw new IllegalArgumentException("Wrong Social Security Number: " + ssn );
        }
        this.name = name;
        this.socialSecurityNumber = ssn;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

//    public static void main(String[] args) {
//        Patient jo = new Patient("Jack","125",1992);
////        Patient rosszEv = new Patient("Jack","125",1885);
////        Patient rosszNev = new Patient("","125",1992);
//    }
}
