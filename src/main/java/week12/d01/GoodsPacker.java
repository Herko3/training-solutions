package week12.d01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsPacker {

    public int packGoods(int[][] types, int capacity) {
        List<Product> productsSortedByRate = createAndSortByRate(types);
        int sumWeight = 0;
        int sumPrice = 0;
        for (Product product : productsSortedByRate) {
            while ((sumWeight + product.getWeight()) <= capacity) {
                sumWeight += product.getWeight();
                sumPrice += product.getPrice();
            }
        }
        return sumPrice;
    }

    private List<Product> createAndSortByRate(int[][] types) {
        List<Product> products = new ArrayList<>();
        for (int[] type : types) {
            products.add(new Product(type[0], type[1]));
        }
        Collections.sort(products);
        return products;
    }

}
