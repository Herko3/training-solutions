package methodstructure;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendrives){
        Pendrive best = pendrives.get(0);
        for(Pendrive item : pendrives){
            if(best.comparePricePerCapacity(item) == 1){
                best = item;
            }
        }
        return best;
    }

    public Pendrive cheapest(List<Pendrive> pendrives){
        Pendrive cheapest = pendrives.get(0);
        for(Pendrive item : pendrives){
            if (!cheapest.cheaperThan(item)){
                cheapest = item;
            }
        }
        return cheapest;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity){
        for(Pendrive item : pendrives){
            if(item.getCapacity()==capacity){
                item.risePrice(percent);
            }
        }
    }

}
