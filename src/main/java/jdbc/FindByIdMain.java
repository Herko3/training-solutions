package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByIdMain {

    public void selectNameByID(DataSource dataSource, long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select emp_name from employees where id=?")
        ) {
            stmt.setLong(1, id);

            selectNameByPreparedStatement(stmt);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    private void selectNameByPreparedStatement(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("emp_name");
                System.out.println(name);
            } else {
                throw new IllegalArgumentException("Not found");
            }

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");

        } catch (
                SQLException se) {
            throw new IllegalStateException("Cannot create data source", se);
        }

        new FindByIdMain().selectNameByID(dataSource, 3);
    }

}
