package week15.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class TaskManager {

    private final String PATTERN_OF_DATE = "yyyy.MM.dd";

    private List<Order> orders = new ArrayList<>();

    public void readFile(BufferedReader reader) {
        try (reader) {
            LocalDate date = null;
            String courier;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() == PATTERN_OF_DATE.length()) {
                    date = LocalDate.parse(line, DateTimeFormatter.ofPattern(PATTERN_OF_DATE));
                }

                if (line.startsWith("FUT")) {
                    courier = line;
                    String addressLine = reader.readLine();
                    addOrder(date, courier, addressLine);
                }

            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public Optional<Order> getOrderByDateTime(LocalDateTime dateTime) {
        return orders.stream()
                .filter(o -> o.orderDateTime().equals(dateTime))
                .findAny();
    }

    public LocalDate worstDay(){
        Map<LocalDate, Long> ordersByDate = orders.stream()
                .collect(groupingBy(Order::getDate, counting()));

        long orders = Integer.MAX_VALUE;
        LocalDate resultDate = null;

        for(Map.Entry<LocalDate,Long> entry : ordersByDate.entrySet()){
            long actualOrders = entry.getValue();
            if(actualOrders < orders){
                orders = actualOrders;
                resultDate = entry.getKey();
            }
        }

        return resultDate;

    }

    public Map<String, Long> ordersByCourier() {
        return orders.stream()
                .collect(groupingBy(Order::getCourier, counting()));
    }

    public String getAddressWithMostOrders() {
        Map<String, Long> addressOrders = orders.stream()
                .collect(groupingBy(Order::getAddress, counting()));

        long orders = 0;
        String resultAddress = null;

        for(Map.Entry<String,Long> entry : addressOrders.entrySet()){
            long actualOrders = entry.getValue();
            if(actualOrders > orders){
                orders = actualOrders;
                resultAddress = entry.getKey();
            }
        }

        return resultAddress;
    }

    private void addOrder(LocalDate date, String courier, String addressLine) {
        int startIndexOfDate = addressLine.indexOf(":") - 2;
        String address = addressLine.substring(0, startIndexOfDate - 1);

        String time = addressLine.substring(startIndexOfDate);
        LocalTime localTime = LocalTime.parse(time);

        orders.add(new Order(date, localTime, address, courier));
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

}
