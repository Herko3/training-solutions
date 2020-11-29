package defaultconstructor;

public class SimpleDate {

    private static final int[] DAYSOFMONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (!isCorrect(year, month, day)) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
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

    private boolean isCorrect(int year, int month, int day) {

        if (year < 1900) {
            return false;
        }
        if (month < 0 || month > 12) {
            return false;
        }
        if (day < 0 || day > calculateMonthLength(year, month)) {
            return false;
        }
        return true;
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    private int calculateMonthLength(int year, int month) {
        if (isLeapYear(year) && month == 2) {
            return DAYSOFMONTH[month - 1] + 1;
        }
        return DAYSOFMONTH[month - 1];
    }

}


