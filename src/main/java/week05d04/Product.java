package week05d04;

import java.time.LocalDate;

public class Product {

    private String name;
    private LocalDate expire;

    public Product(String name, int year, int month, int day) {
        this.name = name;
        expire = LocalDate.of(year,month,day);
    }
}
