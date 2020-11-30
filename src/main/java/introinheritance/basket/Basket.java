package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cant be null");
        }
        items.add(item);
    }

    public void removeItem(String barcode) {
        if(isEmpty(barcode)){
            throw new IllegalArgumentException("Barcode must be filled!");
        }
        List<Item> delete = new ArrayList<>();
        for(Item item : items){
            if(item.getBarcode().equals(barcode)){
                delete.add(item);
            }
        }
        items.removeAll(delete);
    }

    public void clearBasket(){
        items.clear();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    private boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }
}
