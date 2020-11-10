package controlselection.greetings;

import java.time.LocalTime;

public class Greetings {

    public String greeting(int hour, int min) {
        int time = min + 60 * hour;
        if (time > 300 && time <= 540) {
            return "Jó reggelt!";
        } else if (time > 540 && time <= (18 * 60 + 30)) {
            return "Jó napot!";
        } else if (time >(18 * 60 + 30) && time <=1200){
            return "Jó estét!";
        } else {
            return "Jó éjt!";
        }

    }

    public static void main(String[] args) {
        Greetings test = new Greetings();
        System.out.println("4:55");
        System.out.println(test.greeting(4,55));
        System.out.println("8:55");
        System.out.println(test.greeting(8,55));
        System.out.println("16:55");
        System.out.println(test.greeting(16,55));
        System.out.println("19:00");
        System.out.println(test.greeting(19,0));
        System.out.println("20:00");
        System.out.println(test.greeting(20,0));
        System.out.println("21:00");
        System.out.println(test.greeting(21,0));
    }


}
