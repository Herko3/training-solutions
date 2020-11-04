package finalmodifer;

public class TaxCalculator {

    private static final double TAX = 0.27;

    public double tax(double price) {
        return price * TAX;
    }

    public double priceWithTax(double price){
        return price+tax(price);
    }

    public static void main(String[] args) {
        TaxCalculator test = new TaxCalculator();

        System.out.println("A termék áfa tartalma: "+ test.tax(1000));
        System.out.println("A termék ára áfával: "+ test.priceWithTax(1000));

    }

}
