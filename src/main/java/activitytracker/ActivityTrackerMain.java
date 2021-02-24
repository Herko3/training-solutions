package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    public void insertActivity(DataSource dataSource, Activity activity) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO activities(start_time, activity_desc, activity_type) VALUES (?,?,?)");
        ) {

            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();

        } catch (SQLException se) {
            throw new IllegalStateException("cannot insert", se);
        }

    }

    public Activity findById(DataSource dataSource, long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from activities where id =?")
        ) {
            stmt.setLong(1, id);
            List<Activity> result = selectActivityByPreparedStatement(stmt);
            if (result.size() == 1) {
                return result.get(0);
            }
            throw new IllegalArgumentException("Not found!");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    private List<Activity> selectActivityByPreparedStatement(PreparedStatement stmt) {
        List<Activity> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Activity activity = new Activity(rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type")));
                result.add(activity);
            }
            return result;

        } catch (SQLException se) {
            throw new IllegalArgumentException("Execute failed!", se);
        }
    }

    public List<Activity> selectAllActivities(DataSource dataSource) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from activities");
        ) {
            return selectActivityByPreparedStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

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

        Activity activity1 = new Activity(LocalDateTime.of(2021, 2, 23, 10, 20), "Biking in Mátra", ActivityType.BIKING);
        Activity activity2 = new Activity(LocalDateTime.of(2021, 2, 23, 11, 20), "Running in Mátra", ActivityType.RUNNING);
        Activity activity3 = new Activity(LocalDateTime.of(2021, 2, 23, 12, 20), "Hiking in Mátra", ActivityType.HIKING);

        ActivityTrackerMain main = new ActivityTrackerMain();
//        main.insertActivity(dataSource, activity1);
//        main.insertActivity(dataSource, activity2);
//        main.insertActivity(dataSource, activity3);

        System.out.println(main.findById(dataSource, 2));
        System.out.println(main.selectAllActivities(dataSource));
    }

}
