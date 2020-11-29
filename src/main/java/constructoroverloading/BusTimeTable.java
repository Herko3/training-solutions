package constructoroverloading;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        int hour = firstHour;
        while (hour <= lastHour) {
            timeTable.add(new SimpleTime(hour,everyMinute));
            hour++;
        }
    }

    public SimpleTime nextBus(SimpleTime actual){
        for(SimpleTime next : timeTable){
            if(actual.difference(next)<0) {
                return next;
            }
        }
        throw new IllegalStateException("No more buses today!");
//        nextDay();
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

    private String nextDay(){
        return "Next bus will leave tomorrow at:" + timeTable.get(0);
    }
}
