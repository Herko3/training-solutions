package week16.d01;

import java.time.LocalDateTime;

public class CanoeRental {

    private static final int PRICE = 5000;

    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CanoeRental(String name, CanoeType canoeType, String dateTimeString) {
        this.name = name;
        this.canoeType = canoeType;
        startTime = LocalDateTime.parse(dateTimeString);
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double calculateRentalSum(){
        return PRICE* canoeType.getBaseRate();
    }

    public boolean isActive(){
        return endTime == null;
    }

    public boolean isDone(){
        return !isActive();
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
