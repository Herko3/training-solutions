package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;

public class ActivityTrackerMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");

        } catch (SQLException se) {
            throw new IllegalStateException("cannot connect", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        ActivityDao activityDao = new ActivityDao(dataSource);
        activityDao.insertActivity(new Activity(LocalDateTime.of(2021,1,1,12,30),"Basketball in park",ActivityType.BASKETBALL));
        activityDao.insertActivity(new Activity(LocalDateTime.of(2021,1,1,15,30),"Biking in park",ActivityType.BIKING));
        System.out.println(activityDao.selectAllActivities());
        System.out.println(activityDao.selectByType(ActivityType.BIKING));
    }

}
