package week06d02;

public class Product {

    private String name;
    private Category category;
    private int price;

    public Product(String name, Category category, int price) {
        if(isEmpty(name)){
            throw new IllegalArgumentException("Product name must not be empty");
        }
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    private boolean isEmpty(String s){
        return s == null || s.isBlank();
    }
}
