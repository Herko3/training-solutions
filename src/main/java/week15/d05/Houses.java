package week15.d05;

public class Houses {

    private String name;
    private int numberOfBattles;

    public Houses(String name, int numberOfBattles) {
        this.name = name;
        this.numberOfBattles = numberOfBattles;
    }

    public void addBattle(){
        numberOfBattles++;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBattles() {
        return numberOfBattles;
    }

    @Override
    public String toString() {
        return "Houses{" +
                "name='" + name + '\'' +
                ", numberOfBattles=" + numberOfBattles +
                '}';
    }
}
