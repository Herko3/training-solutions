package stringbasic;

import java.time.LocalDate;

public class Pet {

    private String name;
    private LocalDate birth;
    private Gender gender;
    private String regNumber;

    public Pet(String name, LocalDate birth, Gender gender, String regNumber) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
