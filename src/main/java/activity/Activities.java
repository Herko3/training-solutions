package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities = new ArrayList<>();

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        for(Activity activity : activities){
           ActivityType type = activity.getType();
           double distance = type.getDistance() + activity.getDistance();
           type.setDistance(distance);
        }
        for(ActivityType type : ActivityType.values()){
            reports.add(new Report(type,type.getDistance()));
        }

        return reports;
    }

    public int numberOfTrackActivities() {
        int counter = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithTrack) {
                counter++;
            }
        }
        return counter;
    }

    public int numberOfWithoutTrackActivities() {
        int counter = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithoutTrack) {
                counter++;
            }
        }
        return counter;
    }
}
