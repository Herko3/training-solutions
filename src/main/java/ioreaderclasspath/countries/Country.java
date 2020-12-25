package ioreaderclasspath.countries;

public class Country {

    private String name;
    private int neighbors;

    public Country(String name, int neighbors) {
        this.name = name;
        this.neighbors = neighbors;
    }

    public String getName() {
        return name;
    }

    public int getNeighbors() {
        return neighbors;
    }
}
