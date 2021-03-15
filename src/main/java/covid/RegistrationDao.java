package covid;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDao {

    private static final int DAYS_BETWEEN_VACCINATIONS = 15;
    private static final int DAILY_VACCINES = 16;
    public static final String SEPARATOR = ";";
    private DataSource dataSource;

    public RegistrationDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertCities(String path) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(SEPARATOR);
                insertCity(parts[0], parts[1]);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void insertCity(String zip, String city) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO cities (zip,city) VALUES (?,?)")
        ) {
            stmt.setString(1, zip);
            stmt.setString(2, city);
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    public void insertCitizen(Citizen citizen) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO citizens (citizen_name,zip,age,email,taj,number_of_vaccination) VALUES (?,?,?,?,?,?)")
        ) {
            stmt.setString(1, citizen.getFullName());
            stmt.setString(2, citizen.getZipcode());
            stmt.setInt(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getSsn());
            stmt.setInt(6, 0);
            stmt.executeUpdate();

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    public String findCityByZip(String zip) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cities WHERE zip=?")
        ) {
            stmt.setString(1, zip);
            return getStringValueFromPreparedStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    private String getStringValueFromPreparedStatement(PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
             if(rs.next()){
                 return rs.getString("city");
             }
             throw new IllegalArgumentException("Cannot query");
        }
    }

    public void insertCitizensFromFile(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(SEPARATOR);
                String name = parts[0];
                String zip = parts[1];
                int age = Integer.parseInt(parts[2]);
                String email = parts[3];
                String ssn = parts[4];
                Citizen citizen = new Citizen(name, zip, age, email, ssn);
                insertCitizen(citizen);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file");
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException();
        }
    }

    public List<Citizen> getCitizenListBy(String zip, LocalDate localDate) {
        localDate.minusDays(DAYS_BETWEEN_VACCINATIONS);
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM citizens WHERE zip = ? AND (number_of_vaccination = 0 OR number_of_vaccination = 1 AND last_vaccination < ?) ORDER BY age DESC, citizen_name LIMIT ?")
        ) {
            stmt.setString(1, zip);
            stmt.setDate(2, Date.valueOf(localDate));
            stmt.setInt(3, DAILY_VACCINES);

            return getListFromPreparedStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select", se);
        }
    }

    private List<Citizen> getListFromPreparedStatement(PreparedStatement stmt) {
        List<Citizen> citizens = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("citizen_name");
                String zip = rs.getString("zip");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String ssn = rs.getString("taj");
                citizens.add(new Citizen(name, zip, age, email, ssn));
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Execute failed", se);
        }
        return citizens;
    }
}
