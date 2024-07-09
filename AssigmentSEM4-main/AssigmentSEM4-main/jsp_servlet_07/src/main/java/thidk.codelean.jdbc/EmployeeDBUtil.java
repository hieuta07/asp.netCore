package thidk.codelean.jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDBUtil {
    private DataSource dataSource;

    public EmployeeDBUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Employee> getEmployees() throws Exception {

        List<Employee> employees = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            String url = "jdbc:mysql://localhost:3306/student_manager";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);
//			myConn = dataSource.getConnection();

            // create sql statement
            String sql = "select * from employee order by employee_name";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                String employeeCode = myRs.getString("employee_code");
                String employeeName = myRs.getString("employee_name");
                String birthday = myRs.getString("birthday");
                String phoneNumber = myRs.getString("phone_number");
                String email = myRs.getString("email");

                // create new student object
                Employee tempEmployee = new Employee(id, employeeCode, employeeName, birthday, phoneNumber, email);

                // add it to the list of students
                employees.add(tempEmployee);
            }

            return employees;
        }
        finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();   // doesn't really close it ... just puts back in connection pool
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void addEmployee(Employee theEmployee) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
//			myConn = dataSource.getConnection();
            // get a connection
            String url = "jdbc:mysql://localhost:3306/student_manager";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            // create sql for insert
            String sql = "insert into employee "
                    + "(employee_code, employee_name, birthday, phone_number, email) "
                    + "values (?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            // set the param values for the student
            myStmt.setString(1, theEmployee.getEmployeeCode());
            myStmt.setString(2, theEmployee.getEmployeeName());
            myStmt.setString(3, theEmployee.getBirthday());
            myStmt.setString(4, theEmployee.getPhoneNumber());
            myStmt.setString(5, theEmployee.getEmail());

            // execute sql insert
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public Employee getEmployee(String theEmployeeId) throws Exception {

        Employee theEmployee = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int employeeId;

        try {
            // convert student id to int
            //ababababababababababababababababsbhsbdflkrjgfhalkdfhalkdfhakdfjhlkadfadkfjbbabdkjfnakldsjfhnjalkdnfklarjhflskajf
            employeeId = Integer.parseInt(String.valueOf(theEmployeeId));

            // get connection to database
//			myConn = dataSource.getConnection();
            // get a connection
            String url = "jdbc:mysql://localhost:3306/student_manager";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            // create sql to get selected student
            String sql = "select * from employee where id=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, employeeId);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                String employeeCode = myRs.getString("employee_code");
                String employeeName = myRs.getString("employee_name");
                String birthday = myRs.getString("birthday");
                String phoneNumber = myRs.getString("phone_number");
                String email = myRs.getString("email");



                // use the studentId during construction
                theEmployee = new Employee(employeeId, employeeCode, employeeName, birthday, phoneNumber, email);
            }
            else {
                throw new Exception("Could not find employee id: " + employeeId);
            }

            return theEmployee;
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public void updateEmployee(Employee theEmployee) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
//			myConn = dataSource.getConnection();
            // get a connection
            String url = "jdbc:mysql://localhost:3306/student_manager";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            // create SQL update statement
            String sql = "update employee "
                    + "set employee_code=?, employee_name=?, birthday=?, phone_number=?, email=? "
                    + "where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, theEmployee.getEmployeeCode());
            myStmt.setString(2, theEmployee.getEmployeeName());
            myStmt.setString(3, theEmployee.getBirthday());
            myStmt.setString(4, theEmployee.getPhoneNumber());
            myStmt.setString(5, theEmployee.getEmail());

            // execute SQL statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public void deleteEmployee(String theEmployeeId) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // convert student id to int
            int employeeId = Integer.parseInt(theEmployeeId);

            // get connection to database
//			myConn = dataSource.getConnection();
            // get a connection
            String url = "jdbc:mysql://localhost:3306/student_manager";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            // create sql to delete student
            String sql = "delete from employee where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, employeeId);

            // execute sql statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC code
            close(myConn, myStmt, null);
        }
    }
}
