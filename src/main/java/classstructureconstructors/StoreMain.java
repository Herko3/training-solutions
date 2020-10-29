package classstructureconstructors;

public class StoreMain {

    public static void main(String[] args) {
        Store store = new Store("Alma");
        Store anotherStore = new Store("Banán");

        store.store(250);
        System.out.println("Termék: "+ store.getProduct() + " Készlet: " + store.getStock());

        anotherStore.dispatch(128);
        System.out.println("Termék: "+ anotherStore.getProduct() + " Készlet: " + anotherStore.getStock());

        store.dispatch(145);
        System.out.println("Termék: "+ store.getProduct() + " Készlet: " + store.getStock());

        anotherStore.store(248);
        System.out.println("Termék: "+ anotherStore.getProduct() + " Készlet: " + anotherStore.getStock());
    }
}
