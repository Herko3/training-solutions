package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectEmployeesMain {

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

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select emp_name from employees");
                ResultSet rs = stmt.executeQuery();
        ) {
            List<String> names = new ArrayList<>();
            while(rs.next()){
                String name = rs.getString("emp_name");
                names.add(name);
            }
            System.out.println(names);

        } catch (SQLException se) {
            throw new IllegalStateException("cannot connect", se);
        }

    } //main vége

}
