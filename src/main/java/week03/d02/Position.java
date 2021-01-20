package week03.d02;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return name + " " + bonus;
    }

    public static void main(String[] args) {
        Position boss = new Position("Boss",250000);
        Position manager = new Position("Manager",200000);
        Position employee = new Position("Employee",120000);

        List<Position> position = new ArrayList<>();
        position.add(boss);
        position.add(manager);
        position.add(employee);

        for (Position test : position){
            if (test.getBonus()>150000){
                System.out.println(test);
            }
        }


    }
}
