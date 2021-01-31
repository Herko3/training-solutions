package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public BigDecimal getTotalIncome() {
        BigDecimal result = orders.stream().map(CoffeeOrder::income).reduce(BigDecimal.ZERO,BigDecimal::add);
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        BigDecimal result = orders.stream().filter(co -> co.getDateTime().toLocalDate().equals(date)).map(CoffeeOrder::income).reduce(BigDecimal.ZERO,BigDecimal::add);
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return orders.stream().flatMap(l -> l.getCoffeeList().stream()).filter(c -> c.getType() == type).count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from){
        return orders.stream().filter(co->co.getDateTime().isAfter(from)).collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date){
        return orders.stream().sorted(Comparator.comparing(CoffeeOrder::getDateTime)).filter(co -> co.getDateTime().toLocalDate().equals(date)).limit(5).collect(Collectors.toList());
    }


}
