package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private List<Feature> features = new ArrayList<>();
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, List<Feature> features) {
        this.features = features;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

//    public int fullLengthAtOneItem(){
//        int length = 0;
//        for(Feature feature : features){
//
//        }
//    }

    public List<String> getContributors(){
        List<String> contributor = new ArrayList<>();
        for(Feature feature: features){
            contributor.addAll(feature.getContributors());
        }
        return contributor;
    }

    public List<String> getTitles(){
        List<String> titles = new ArrayList<>();
        for(Feature feature: features){
            titles.add(feature.getTitle());
        }
        return titles;
    }

    public boolean hasAudioFeature(){
        for (Feature feature : features){
            if(feature instanceof AudioFeatures){
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature(){
        for (Feature feature : features){
            if(feature instanceof PrintedFeatures){
                return true;
            }
        }
        return false;
    }

//    public int numberOfPagesAtOneItem(){
//
//    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
