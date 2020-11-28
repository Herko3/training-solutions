package methodpass;

public class Trooper {

    private String name;
    private Position position;

    public Trooper(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
        position = new Position(0, 0);
    }

    public void changePosition(Position target) {
        isEmpty(target);
        position = new Position(target.getPosX(), target.getPosY());
    }

    public double distanceFrom(Position target) {
        isEmpty(target);
        return position.distanceFrom(target);
    }

    private boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }

    private void isEmpty(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Target must not be empty");
        }
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
