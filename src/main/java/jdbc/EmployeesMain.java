package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

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

        EmployeesDao employeesDao= new EmployeesDao(dataSource);
        employeesDao.createEmployee("John Doe");

        System.out.println(employeesDao.listEmployeeNames());
        System.out.println(employeesDao.findEmployeeById(103));

    } // main vége

}
