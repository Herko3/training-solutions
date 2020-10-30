package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adjon meg egy terméket");
        String name = scanner.nextLine();
        System.out.println("Adja meg a termék árát");
        int price = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product (name,price);
        System.out.println("Termék neve: " + product.getName());
        System.out.println("Termék ára: " + product.getPrice());

        System.out.println("Növelje a termék árát az alábbi mennyiséggel:");
        product.increasePrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("A termék ára ezzel:" + product.getPrice());

        System.out.println("Csökkentse a termék árát az alábbi mennyiséggel:");
        product.decreasePrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("A termék ára ezzel:" + product.getPrice());
    }
}
