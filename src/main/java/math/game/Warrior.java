package math.game;

import java.util.Random;

public class Warrior {

    private static final Random random = new Random();

    private String name;
    private Point position;
    private int stamina;
    private double skill;

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        stamina = random.nextInt(81) + 20;
        skill = random.nextDouble();

    }

    public Point getPosition(){
        return position;
    }

    public void move(Warrior movement){
        int newX = position.getX();
        int newY = position.getY();
        if(movement.getPosition().getX() - position.getX() > 0){
            newX++;
        } else if(movement.getPosition().getX() - position.getX() < 0){
            newX--;
        }
        if(movement.getPosition().getY() - position.getY() > 0){
            newY++;
        } else if (movement.getPosition().getY()-position.getY() <0){
            newY--;
        }
        position = new Point(newX,newY);
    }

    public void attack(Warrior dmg){
        if (random.nextDouble()<skill){
            dmg.stamina -= random.nextInt(3)+1;
        }

    }

    public double distance (Warrior tav){
        return position.distance(tav.position);
    }

    public boolean isAlive(){
        return stamina>0;
    }

    public String toString(){
        return name + ": " + "("+position.getX()+ "," + position.getY()+") "+ stamina;
    }

//    public static void main(String[] args) {
//        Warrior test1 = new Warrior("Jack",new Point(1,2));
//        Warrior test2 = new Warrior("Joe", new Point(3,2));
//
//        System.out.println(test1.toString());
//        System.out.println(test2.toString());
//        System.out.println(test1.isAlive());
//        test1.attack(test2);
//        System.out.println(test1.toString());
//        System.out.println(test2.toString());
//
//    }
}
