package lambdaprimitives;

import java.util.IntSummaryStatistics;
import java.util.List;

public class SportGadgetStore {

    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public int getNumberOfProducts() {
        return products.stream().mapToInt(Product::getQuantity).sum();
    }

    public double getAveragePrice() {
        return products.stream().mapToDouble(Product::getPrice).summaryStatistics().getAverage();
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics stats = products.stream().filter(p -> p.getPrice() >= minPrice).mapToInt(Product::getQuantity).summaryStatistics();
        int count = (int) stats.getCount();
        int min = stats.getMin();
        int max = stats.getMax();
        int sum = (int) stats.getSum();
        if(count == 0){
            return "Nincs ilyen termék.";
        }
        return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.",count,min,max,sum);
    }
}
