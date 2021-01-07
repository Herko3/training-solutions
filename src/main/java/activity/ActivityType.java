package activity;

public enum ActivityType {

    BIKING(0),HIKING(0),RUNNING(0),BASKETBALL(0);

    private double distance;

    ActivityType(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
