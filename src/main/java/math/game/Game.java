package math.game;

public class Game {

    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("Jack",new Point(5,2));
        Warrior warrior2 = new Warrior("Joe", new Point(3,6));

        System.out.println("Starting Positions");
        System.out.println(warrior1.toString());
        System.out.println(warrior2.toString());

        for (int round =1; warrior1.isAlive()&& warrior2.isAlive();round++){
            System.out.println("Round " + round + ".");
            if(warrior1.distance(warrior2)>0){
                warrior1.move(warrior2);
                if(warrior2.distance(warrior1)>0){
                    warrior2.move(warrior1);
                }
            }else{
                warrior1.attack(warrior2);
                if(warrior2.isAlive()){
                    warrior2.attack(warrior1);
                }
            }
            System.out.println(warrior1.toString());
            System.out.println(warrior2.toString());
        }
        System.out.println("And the winner is: " + (warrior1.isAlive() ? warrior1.getName() : warrior2.getName()));
        System.out.println("All hail the winner!");
    }
}
