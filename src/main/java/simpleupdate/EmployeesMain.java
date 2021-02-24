package simpleupdate;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;

public class EmployeesMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot create data source", se);
        }

//        for (int i = 0; i < 100; i++) {
//            try (
//                    Connection conn = dataSource.getConnection();
//                    PreparedStatement stmt =
//                            conn.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)")
//            ) {
//                stmt.setString(1, "John Doe");
//                stmt.executeUpdate();
//
//            } catch (SQLException se) {
//                throw new IllegalStateException("cannot insert", se);
//            }
//        }

        try(
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT emp_name FROM employees")

                ){

            while(rs.next()){
                String name = rs.getString("emp_name");
                System.out.println(name);
            }

        } catch (SQLException se){
            throw new IllegalStateException("cannot select", se);
        }

    } //main vége

}
