package lambdacomparator.cloud;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clouds {

    public CloudStorage alphabeticallyFirst(List<CloudStorage> clouds) {
        clouds.sort(Comparator.comparing(CloudStorage::getProvider, Comparator.comparing(s -> s.trim().toLowerCase())));
        return clouds.get(0);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> clouds) {
        List<CloudStorage> result = new ArrayList<>(clouds);
        result.sort(Comparator.comparing(CloudStorage::getPeriod, Comparator.nullsFirst(Comparator.comparingInt(PayPeriod::getLength))).thenComparingDouble(CloudStorage::getPrice));
        return result.get(0);
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> clouds) {
        List<CloudStorage> sorted = new ArrayList<>(clouds);
        sorted.sort(Comparator.reverseOrder());
        List<CloudStorage> result = new ArrayList<>();
        if(sorted.size() <  3){
            return sorted;
        }
        for (int i = 0; i < 3; i++) {
            result.add(sorted.get(i));
        }
        return result;
    }
}
