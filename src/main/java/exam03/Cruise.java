package exam03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers() <= passengers.size()) {
            throw new IllegalArgumentException("Not enough space");
        }
        passengers.add(passenger);
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getPriceRate() * basicPrice;
    }

    public Passenger findPassengerByName(String name){
        for(Passenger passenger : passengers){
            if(passenger.getName().equals(name)){
                return passenger;
            }
        }
        throw new IllegalArgumentException("No passenger with name: " + name);
    }

    public List<String> getPassengerNamesOrdered(){
        return passengers.stream()
                .map(Passenger::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public double sumAllBookingsCharged(){
        return passengers.stream()
                .mapToDouble(this::getPriceForPassenger)
                .sum();
    }

    public Map<CruiseClass,Long> countPassengerByClass(){
        return passengers.stream()
                .map(Passenger::getCruiseClass)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }
}
