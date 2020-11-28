package methodpass;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private List<Trooper> troopers = new ArrayList<>();

    public void addTrooper (Trooper trooper){
         if(trooper == null){
             throw new IllegalArgumentException("Trooper can't be null");
         }
         troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target){
        findTrooperByName(name).changePosition(target);
    }

    public void moveClosestTrooper(Position target){
        findClosestTrooper(target).changePosition(target);
    }

    private Trooper findTrooperByName(String name){
        for(Trooper trooper :  troopers){
            if(trooper.getName().equals(name)){
                return trooper;
            }
        }
        throw new IllegalArgumentException("No trooper by this name");
    }

    private Trooper findClosestTrooper(Position target){
        Trooper closest = troopers.get(0);
        for (Trooper trooper : troopers){
            if(trooper.distanceFrom(target)< closest.distanceFrom(target)){
                closest = trooper;
            }
        }
        return closest;
    }

    public List<Trooper> getTroopers() {
        return troopers;
    }

    private boolean isEmpty(String s){
        return s == null || s.isBlank();
    }
}
