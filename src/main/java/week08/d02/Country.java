package week08.d02;

public class Country {

    private String name;
    private int population;
    private int numberOfColors;
    private int neighbors;

    public Country(String name, int population, int numberOfColors, int neighbors) {
        this.name = name;
        this.population = population;
        this.numberOfColors = numberOfColors;
        this.neighbors = neighbors;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getNumberOfColors() {
        return numberOfColors;
    }

    public int getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", numberOfColors=" + numberOfColors +
                ", neighbors=" + neighbors +
                '}';
    }
}
