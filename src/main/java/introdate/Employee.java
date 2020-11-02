package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {
    private String name;
    private LocalDate dayOfBirth;
    private LocalDateTime beginEmployement;

    public Employee(int year, int month, int day, String name) {
        this.dayOfBirth = LocalDate.of(year,month,day);
        this.name = name;
        this.beginEmployement = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public LocalDateTime getBeginEmployement() {
        return beginEmployement;
    }
}
