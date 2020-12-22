package week06.d04;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public void addItem(String name, int quantity) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Item name must not be empty");
        }
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new Item(name, quantity));
    }

    public int getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item.getQuantity();
            }
        }
        return 0;
    }

    private boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }

    public List<Item> getItems() {
        return items;
    }
}
