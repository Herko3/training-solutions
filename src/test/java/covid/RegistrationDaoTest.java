package covid;

import activitytracker.ActivityDao;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationDaoTest {

    RegistrationDao dao;

    @BeforeEach
    public void init() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid_vaccination?useUnicode=true");
            dataSource.setUser("covid_vaccination");
            dataSource.setPassword("covid_vaccination");

        } catch (SQLException se) {
            throw new IllegalStateException("cannot connect", se);
        }

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/covid")
                .dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        dao = new RegistrationDao(dataSource);
    }

    @Test
    public void createTest() {
        Citizen citizen = new Citizen("John Doe", "1214", 28, "jd@gmail.com", "123456781");
        dao.insertCitizen(citizen);

        assertEquals("John Doe", dao.getCitizenListBy("1214",LocalDate.now()).get(0).getFullName());
    }

    @Test
    public void insertFromFile() {
        String filePath = "src/main/resources/covid/data.csv";
        dao.insertCitizensFromFile(filePath);
    }

    @Test
    public void insertCities(){
        dao.insertCities("src/main/resources/week13/d01/iranyitoszamok-varosok-2021.csv");
        String city = dao.findCityByZip("2038");
        assertEquals("Sóskút",city);
    }

}