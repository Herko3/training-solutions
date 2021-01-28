package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {

    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem another){
        employee = another.employee;
        project = another.project;
        from = another.from;
        to = another.to;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate time){
        TimeSheetItem another = new TimeSheetItem(timeSheetItem);
        int day = time.getDayOfMonth();
        another.setFrom(another.getFrom().withDayOfMonth(day));
        another.setTo(another.getTo().withDayOfMonth(day));
        return another;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }
}
