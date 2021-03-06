package lambdaintermediate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CoffeeOrder {

    private List<Coffee> coffeeList;
    private LocalDateTime dateTime;

    public CoffeeOrder(List<Coffee> coffeeList, LocalDateTime dateTime) {
        this.coffeeList = coffeeList;
        this.dateTime = dateTime;
    }

    public BigDecimal income(){
        return coffeeList.stream().map(Coffee::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public List<Coffee> getCoffeeList() {
        return new ArrayList<>(coffeeList);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
