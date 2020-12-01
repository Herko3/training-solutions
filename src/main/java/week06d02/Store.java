package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public Store(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("The list must not be empty");
        }

        this.products = products;
    }

    public NumberOfProducts getProductsByCategory() {
        int dairy = 0;
        int other = 0;
        int baked = 0;
        int frozen = 0;

        for (Product product : products) {
            switch (product.getCategory()) {
                case DAIRY:
                    dairy++;
                    break;
                case OTHER:
                    other++;
                    break;
                case FROZEN:
                    frozen++;
                    break;
                case BAKEDGOODS:
                    baked++;
                    break;
            }
        }
        return new NumberOfProducts(frozen, other, dairy, baked);
    }


}
