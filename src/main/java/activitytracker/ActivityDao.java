package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Activity insertActivity(Activity activity) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO activities(start_time, activity_desc, activity_type) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)
        ) {

            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();

            Activity result = getIdAfterExecute(activity, stmt);
            uploadTrackPoints(result.getId(), activity.getTrackPoints());
            return result;

        } catch (SQLException se) {
            throw new IllegalStateException("cannot insert", se);
        }

    }

    private Activity getIdAfterExecute(Activity activity, PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                long id = rs.getLong(1);

                return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());
            }
            throw new IllegalStateException("Cannot get generated key");
        }
    }

    private void uploadTrackPoints(long id, List<TrackPoint> trackPoints) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO track_point (act_time,lat,lon,activityId) VALUES (?,?,?,?)")) {
                for (TrackPoint trackPoint : trackPoints) {
                    if (Math.abs(trackPoint.getLat()) > 90 || Math.abs(trackPoint.getLon()) > 180) {
                        throw new IllegalArgumentException("Invalid latitude or longitude");
                    }
                    stmt.setDate(1, Date.valueOf(trackPoint.getTime()));
                    stmt.setDouble(2, trackPoint.getLat());
                    stmt.setDouble(3, trackPoint.getLon());
                    stmt.setLong(4, id);
                    stmt.executeUpdate();
                }
                conn.commit();
            } catch (IllegalArgumentException iae) {
                conn.rollback();
                throw new IllegalStateException("Due to invalid rows, the database was rollbacked");
            }

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    public Activity findById(long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM activities WHERE id=?");
                PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM track_point WHERE activityId=?")
        ) {
            stmt.setLong(1, id);
            List<Activity> result = selectActivityByPreparedStatement(stmt);
            if (result.size() == 1) {
                stmt2.setLong(1,id);
                List<TrackPoint> resultPoints = selectTrackPointsByPreparedStatement(stmt2);
                Activity activity = result.get(0);
                activity.addTrackPoints(resultPoints);
                return activity;
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

    private List<TrackPoint> selectTrackPointsByPreparedStatement(PreparedStatement stmt) {
        List<TrackPoint> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TrackPoint trackPoint = new TrackPoint(rs.getLong("id"),rs.getDate("act_time").toLocalDate(),rs.getDouble("lat"),rs.getDouble("lon"));
                result.add(trackPoint);
            }
            return result;

        } catch (SQLException se) {
            throw new IllegalArgumentException("Execute failed!", se);
        }
    }

    public List<Activity> selectAllActivities() {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM activities")
        ) {
            return selectActivityByPreparedStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    public List<Activity> selectByType(ActivityType type) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM activities WHERE activity_type=?")
        ) {
            stmt.setString(1, type.toString());
            return selectActivityByPreparedStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    public List<Activity> selectActivitiesBeforeDate(LocalDate date) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM activities WHERE start_time<?")
        ) {

            LocalDateTime actualDate = date.atTime(0, 0);

            stmt.setTimestamp(1, Timestamp.valueOf(actualDate));
            return selectActivityByPreparedStatement(stmt);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }
}
