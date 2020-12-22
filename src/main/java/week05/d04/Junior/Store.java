package week05.d04.Junior;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public int getNumberOfExpired(){
        int expired = 0;
        for(Product product : products){
            if(product.getExpire().isBefore(LocalDate.now())){
                expired++;
            }
        }
        return expired;
    }

    public List<Product> getProducts() {
        return products;
    }
}
