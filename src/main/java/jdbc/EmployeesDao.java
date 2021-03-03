package jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    private DataSource dataSource;

    public EmployeesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createEmployee(String name) {

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)")
        ) {
            stmt.setString(1, name);
            stmt.executeUpdate();

        } catch (SQLException se) {
            throw new IllegalStateException("cannot insert", se);
        }
    }

    public List<String> listEmployeeNames() {
        List<String> names = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT emp_name FROM employees");
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                names.add(rs.getString("emp_name"));
            }

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
        return names;
    }

    public String findEmployeeById(long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT emp_name FROM employees WHERE id=?")
        ) {
            stmt.setLong(1, id);
            return selectNameByPreparedStatement(stmt);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

    private String selectNameByPreparedStatement(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("emp_name");
            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

}
