package week15.d02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Order {

    private LocalDate date;
    private LocalTime time;
    private String address;
    private String courier;

    public Order(LocalDate date, LocalTime time, String address, String courier) {
        this.date = date;
        this.time = time;
        this.address = address;
        this.courier = courier;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }

    public String getCourier() {
        return courier;
    }

    public LocalDateTime orderDateTime(){
        return LocalDateTime.of(date,time);
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", time=" + time +
                ", address='" + address + '\'' +
                ", courier='" + courier + '\'' +
                '}';
    }
}
