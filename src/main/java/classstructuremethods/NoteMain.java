package classstructuremethods;

public class NoteMain {

    public static void main(String[] args) {
        Note note = new Note();
        note.setName("Jack");
        note.setTopic("Struktúraváltás");
        note.setText("Kezdési idő: 2020.10.28");

        System.out.println(note.getNoteText());
    }
}
