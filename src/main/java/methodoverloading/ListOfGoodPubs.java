package methodoverloading;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> pubs = new ArrayList<>();

    public ListOfGoodPubs(List<Pub> pubs) {
        if(pubs == null || pubs.size() == 0){
            throw new IllegalArgumentException("Pub list is empty!");
        }

        this.pubs = pubs;
    }

    public Pub findTheBest(){
        Pub best = pubs.get(0);
        for(int i = 0; i<pubs.size(); i++){
         if(!best.getOpenFrom().isEarlier(pubs.get(i).getOpenFrom())){
             best = pubs.get(i);
         }
        }
        return best;
    }

}
