package interfacestaticmethods;

import java.util.List;

public interface Valued {

    double getValue();

    static double sum(List<Valued> values) {
        double sumValues = 0;
        for (Valued actual : values) {
            sumValues += actual.getValue();
        }
        return sumValues;
    }
}
