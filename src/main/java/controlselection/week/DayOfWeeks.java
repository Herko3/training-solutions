package controlselection.week;

public class DayOfWeeks {

    public String dayType(String day){
        switch(day.toLowerCase()){
            case "hétfő":
                return "A hét eleje";
            case "kedd":
            case "szerda":
            case "csütörtök":
                return "hét közepe";
            case "péntek":
                return "majdnem a hét vége";
            case "szombat":
            case "vasárnap":
                return "a hét vége";
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    public static void main(String[] args) {
        DayOfWeeks test = new DayOfWeeks();
        System.out.println(test.dayType("hétfő"));
        System.out.println(test.dayType("szerda"));
        System.out.println(test.dayType("péntek"));
        System.out.println(test.dayType("vasárnap"));
        System.out.println(test.dayType("sad"));


    }
}
