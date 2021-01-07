package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public void loadFromGpx(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            Coordinate coordinate = null;
            String line;
            while ((line = reader.readLine()) != null){
                line = line.trim();
                if(line.startsWith("<trkpt")){
                    double latitude = Double.parseDouble(line.substring(12,22));
                    double longitude = Double.parseDouble(line.substring(29,39));
                    coordinate = new Coordinate(latitude,longitude);
                }
                if(line.startsWith("<ele")){
                    double ele = Double.parseDouble(line.substring(5,10));
                    trackPoints.add(new TrackPoint(coordinate,ele));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public Coordinate findMaximumCoordinate() {
        double latitude = trackPoints.get(0).getCoordinate().getLatitude();
        double longitude = trackPoints.get(0).getCoordinate().getLongitude();

        for (TrackPoint trackPoint : trackPoints) {
            double actualLat = trackPoint.getCoordinate().getLatitude();
            double actualLong = trackPoint.getCoordinate().getLongitude();

            if (actualLat > latitude) {
                latitude = actualLat;
            }
            if (actualLong > longitude) {
                longitude = actualLong;
            }
        }
        return new Coordinate(latitude, longitude);
    }

    public Coordinate findMinimumCoordinate() {
        double latitude = trackPoints.get(0).getCoordinate().getLatitude();
        double longitude = trackPoints.get(0).getCoordinate().getLongitude();

        for (TrackPoint trackPoint : trackPoints) {
            double actualLat = trackPoint.getCoordinate().getLatitude();
            double actualLong = trackPoint.getCoordinate().getLongitude();

            if (actualLat < latitude) {
                latitude = actualLat;
            }
            if (actualLong < longitude) {
                longitude = actualLong;
            }
        }
        return new Coordinate(latitude, longitude);
    }

    public double getFullDecrease() {
        double decreaseSum = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            double first = trackPoints.get(i - 1).getElevation();
            double second = trackPoints.get(i).getElevation();
            if (first > second) {
                decreaseSum += first - second;
            }
        }
        return decreaseSum;
    }

    public double getFullElevation() {
        double elevateSum = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            double first = trackPoints.get(i - 1).getElevation();
            double second = trackPoints.get(i).getElevation();
            if (first < second) {
                elevateSum += second - first;
            }
        }
        return elevateSum;
    }

    public double getDistance() {
        double sumDistance = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            sumDistance += trackPoints.get(i).getDistanceFrom(trackPoints.get(i - 1));
        }
        return sumDistance;
    }

    public double getRectangleArea() {
        Coordinate upper = findMaximumCoordinate();
        Coordinate lower = findMinimumCoordinate();

        double width = Math.abs(upper.getLatitude() - lower.getLatitude());
        double length = Math.abs(upper.getLongitude() - lower.getLongitude());

        return width * length;
    }

    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }
}
