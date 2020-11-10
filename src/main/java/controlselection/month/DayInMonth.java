package controlselection.month;

public class DayInMonth {

    public int numberOfDays(int year, String month) {
        int day;
        String monthOf = month.toLowerCase();
        switch (monthOf) {
            case "január":
            case "március":
            case "május":
            case "július":
            case "augusztus":
            case "október":
            case "december":
                day = 31;
                break;
            case "április":
            case "június":
            case "szeptember":
            case "november":
                day = 30;
                break;
            case "február":
                if (year%4==0 && (year%400==0 || year % 100!=0)){
                    day=29;
                    break;
                } else {
                    day = 28;
                    break;
                }
            default:
                throw new IllegalArgumentException("Invalid month: " + month);

        }
        return day;
    }

    public static void main(String[] args) {
        DayInMonth test = new DayInMonth();
        System.out.println(test.numberOfDays(2100,"február"));
    }

}
