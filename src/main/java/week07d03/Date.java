package week07d03;

public class Date {

    private static final int[] DAY_OF_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        if (month <= 0 || month > 12 || day <= 0 || day > DAY_OF_MONTH[month-1]){
            throw new IllegalArgumentException("Date is not valid");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static Date of(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return new Date(year, month, day);
    }

    public Date withMonth(int month) {
        return new Date(year, month, day);
    }

    public Date withDay(int day) {
        return new Date(year, month, day);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
