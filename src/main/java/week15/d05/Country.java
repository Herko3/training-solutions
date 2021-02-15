package week15.d05;

public class Country {

    private String name;
    private int population;
    private int cases;

    public Country(String name, int population, int cases) {
        this.name = name;
        this.population = population;
        this.cases = cases;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getCases() {
        return cases;
    }

    public void addCases(int newCases) {
        cases += newCases;
    }

    public double casePerPopulation(){
        return (double)population/cases;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", cases=" + cases +
                '}';
    }
}
