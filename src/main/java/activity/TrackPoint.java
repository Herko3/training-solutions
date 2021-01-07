package activity;

public class TrackPoint {

    private Coordinate coordinate;
    private double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public double getDistanceFrom(TrackPoint trackPoint) {
        final int R = 6371;
        double latDistance = Math.toRadians(trackPoint.getCoordinate().getLatitude() - coordinate.getLatitude());
        double longDistance = Math.toRadians(trackPoint.getCoordinate().getLongitude() - coordinate.getLongitude());

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(trackPoint.getCoordinate().getLatitude())) * Math.cos(Math.toRadians(coordinate.getLatitude()))
                * Math.sin(longDistance / 2) * Math.sin(longDistance / 2);
        double b = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * b * 1000;

        double height = trackPoint.getElevation() - elevation;

        return Math.sqrt((Math.pow(distance, 2) + Math.pow(height, 2)));
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }
}
