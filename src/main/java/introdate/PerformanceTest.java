package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019,5,16);
        String artist = "Linkin Park";
        LocalTime starTime = LocalTime.of(20,30);
        LocalTime endTime = LocalTime.of(22,30);
        Performance concert = new Performance(date,artist,starTime,endTime);

        System.out.println(concert.getInfo());

    }

}
