package classstructureconstructors;

public class BookMain {

    public static void main(String[] args) {

            Book book = new Book("Sir Arthur Connan Doyle", "Sherlock Holmes");
            book.register("1287");

        System.out.println("Szerző: " + book.getAuthor());
        System.out.println("Cím: " + book.getTitle());
        System.out.println("Regisztrációs szám: " + book.getRegNumber());
    }


}
