package algorithmsmax;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer trainerWithMaxAge(List<Trainer> trainers){
        Trainer maxAge = null;
        for(Trainer search :  trainers){
            if(maxAge == null || maxAge.getAge()< search.getAge()){
                maxAge = search;
            }
        }
        return maxAge;
    }

}
