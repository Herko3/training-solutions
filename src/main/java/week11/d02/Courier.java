package week11.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rides = new ArrayList<>();

    public void addRide(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                Ride ride = new Ride(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                validateRide(ride);
                rides.add(ride);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void validateRide(Ride toAdd) {
        if (rides.isEmpty()) {
            return;
        }
        Ride lastRide = rides.get(rides.size() - 1);
        if (lastRide.getDay() > toAdd.getDay() || (lastRide.getDay() == toAdd.getDay() && toAdd.getRideNumber() != lastRide.getRideNumber() + 1)) {
            throw new IllegalArgumentException("The ride is not after the last ride");
        }
    }

    public Ride firstRide() {
        return rides.get(0);
    }

    public boolean[] workDays() {
        boolean[] result = new boolean[7];
        for (Ride ride : rides) {
            int day = ride.getDay();
            result[day - 1] = true;
        }
        return result;
    }

    public int[] dailyDistance() {
        int[] result = new int[7];
        for (Ride ride : rides) {
            result[ride.getDay()-1] += ride.getDistance();
        }
        return result;
    }

    public List<Ride> getRides() {
        return new ArrayList<>(rides);
    }
}
