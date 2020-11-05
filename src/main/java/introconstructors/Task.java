package introconstructors;

import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private int duration;
    private LocalDateTime startDateTime;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void start(){
        startDateTime = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static void main(String[] args) {
    Task task = new Task("TODO","Feladatok");

        System.out.println(task.getTitle() + " " + task.getDescription() + " " + task.getDuration() + " " + task.getStartDateTime() );
        task.start();
        System.out.println(task.getTitle() + " " + task.getDescription() + " " + task.getDuration() + " " + task.getStartDateTime() );
        task.setDuration(120);
        System.out.println(task.getTitle() + " " + task.getDescription() + " " + task.getDuration() + " " + task.getStartDateTime() );


    }
}
