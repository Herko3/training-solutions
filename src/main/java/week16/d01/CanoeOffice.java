package week16.d01;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CanoeOffice {

    private List<CanoeRental> rentals = new ArrayList<>();

    public void createRental(CanoeRental rental) {
        rentals.add(rental);
    }

    public CanoeRental findRentalByName(String name) {
        Optional<CanoeRental> result =
                rentals.stream()
                        .filter(CanoeRental::isActive)
                        .filter(cr -> cr.getName().equals(name))
                        .findAny();

        if (result.isPresent()) {
            return result.get();
        }
        throw new IllegalArgumentException("No rental by such name");
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {
        CanoeRental toEnd = findRentalByName(name);
        if (toEnd.getStartTime().isAfter(endTime)) {
            throw new IllegalArgumentException("StarTime is after EndTime");
        }
        toEnd.setEndTime(endTime);
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental rental = findRentalByName(name);
        if (rental.getStartTime().isAfter(endTime)) {
            throw new IllegalArgumentException("StarTime is after EndTime");
        }
        long hours = Duration.between(rental.getStartTime(), endTime).toHours();
        if(Duration.between(rental.getStartTime(), endTime).toMinutesPart() > 0){
            hours++;
        }
        return rental.calculateRentalSum() * hours;
    }

    public List<CanoeRental> listClosedRentals() {
        return rentals.stream()
                .filter(CanoeRental::isDone)
                .sorted(Comparator.comparing(CanoeRental::getStartTime))
                .collect(Collectors.toList());

    }

    public Map<CanoeType, Long> countRentals() {
        return rentals.stream()
                .map(CanoeRental::getCanoeType)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<CanoeRental> getRentals() {
        return new ArrayList<>(rentals);
    }
}
