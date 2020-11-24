package immutable;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    private List<Satellite> satellites = new ArrayList<>();

    public void registerSatellite (Satellite satellite){
        if(satellite == null){
            throw new NullPointerException("Parameter must not be null!");
        }
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent){
        for(Satellite search : satellites){
            if(search.getRegisterIdent().equalsIgnoreCase(registerIdent)){
                return search;
            }
        }
        throw new IllegalArgumentException("Satellite with the given registration cannot be found! " + registerIdent);
    }

}
