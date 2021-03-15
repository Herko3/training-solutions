package covid;

public class Citizen {

    private String fullName;
    private String zipcode;
    private int age;
    private String email;
    private String ssn;

    public Citizen(String fullName, String zipcode, int age, String email, String ssn) {
        this.fullName = fullName;
        this.zipcode = zipcode;
        this.age = age;
        this.email = email;
        this.ssn = ssn;
    }

    public String getFullName() {
        return fullName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "fullName='" + fullName + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
