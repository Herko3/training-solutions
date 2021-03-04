package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao activityDao;

    @BeforeEach
    public void init() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");

        } catch (SQLException se) {
            throw new IllegalStateException("cannot connect", se);
        }

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/activitytracker")
                .dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    public void selectByIdTest() {

        activityDao.insertActivity(new Activity(LocalDateTime.of(2021, 1, 1, 15, 30), "Biking in park", ActivityType.BIKING));
        Activity activity = activityDao.findById(1);

        assertEquals(ActivityType.BIKING, activity.getType());
    }

    @Test
    public void saveActivity() {
        Activity activity = new Activity(LocalDateTime.of(2021, 1, 1, 15, 30), "Biking in park", ActivityType.BIKING);
        Activity result = activityDao.insertActivity(activity);

        assertEquals("Biking in park", activityDao.findById(result.getId()).getDesc());
    }

    @Test
    public void selectBeforeDateTest() {
        Activity activity = new Activity(LocalDateTime.of(2021, 1, 1, 15, 30), "Biking in park", ActivityType.BIKING);
        Activity activity2 = new Activity(LocalDateTime.of(2021, 1, 2, 15, 30), "Hiking in park", ActivityType.HIKING);
        Activity activity3 = new Activity(LocalDateTime.of(2021, 1, 3, 15, 30), "Running in park", ActivityType.RUNNING);

        activityDao.insertActivity(activity);
        activityDao.insertActivity(activity2);
        activityDao.insertActivity(activity3);

        System.out.println(activityDao.selectActivitiesBeforeDate(LocalDate.of(2021,1,3)));
    }

    @Test
    public void insertActivityWithTrackPoint(){
        Activity activity = new Activity(LocalDateTime.of(2021, 1, 1, 15, 30), "Biking in park", ActivityType.BIKING);
        activity.addTrackPoint(new TrackPoint(LocalDate.of(2021,1,1),0.458,-52.456));
        activity.addTrackPoint(new TrackPoint(LocalDate.of(2021,1,1),15.458,-52.456));

        Activity result = activityDao.insertActivity(activity);

        System.out.println(activityDao.findById(result.getId()));
    }


}