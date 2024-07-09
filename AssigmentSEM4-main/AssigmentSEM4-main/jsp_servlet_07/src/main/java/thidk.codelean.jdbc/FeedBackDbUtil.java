package thidk.codelean.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class FeedBackDbUtil {

    private DataSource dataSource;

    public FeedBackDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<FeedBack> getFeedBacks() throws Exception {

        List<FeedBack> feedbacks = new ArrayList<>();

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
            String sql = "select * from feedback order by name";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                String name = myRs.getString("name");
                String email = myRs.getString("email");
                String subject = myRs.getString("subject");
                String message = myRs.getString("message");

                // create new student object
                FeedBack tempFeedBack = new FeedBack(id, name, email, subject, message);

                // add it to the list of students
                feedbacks.add(tempFeedBack);
            }

            return feedbacks;
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

    public void addFeedBack(FeedBack theFeedBack) throws Exception {

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
            String sql = "insert into feedback "
                    + "(name, email, subject, message) "
                    + "values (?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            // set the param values for the student
            myStmt.setString(1, theFeedBack.getName());
            myStmt.setString(2, theFeedBack.getEmail());
            myStmt.setString(3, theFeedBack.getSubject());
            myStmt.setString(4, theFeedBack.getMessage());

            // execute sql insert
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public FeedBack getFeedBack(String theFeedBackId) throws Exception {

        FeedBack theFeedBack = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int feedBackId;

        try {
            // convert student id to int
            feedBackId = Integer.parseInt(theFeedBackId);

            // get connection to database
//			myConn = dataSource.getConnection();
            // get a connection
            String url = "jdbc:mysql://localhost:3306/student_manager";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            // create sql to get selected student
            String sql = "select * from feedback where id=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, feedBackId);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                String name = myRs.getString("name");
                String email = myRs.getString("email");
                String subject = myRs.getString("subject");
                String message = myRs.getString("message");

                // use the studentId during construction
                theFeedBack = new FeedBack(feedBackId, name, email, subject, message);
            }
            else {
                throw new Exception("Could not find student id: " + feedBackId);
            }

            return theFeedBack;
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public void updateFeedBack(FeedBack theFeedBack) throws Exception {

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
            String sql = "update feedback "
                    + "set name=?, email=?, subject=?, message=? "
                    + "where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, theFeedBack.getName());
            myStmt.setString(2, theFeedBack.getEmail());
            myStmt.setString(3, theFeedBack.getSubject());
            myStmt.setString(4, theFeedBack.getMessage());
            myStmt.setInt(5, theFeedBack.getId());

            // execute SQL statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public void deleteFeedBack(String theFeedBackId) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // convert student id to int
            int feedBackId = Integer.parseInt(theFeedBackId);

            // get connection to database
//			myConn = dataSource.getConnection();
            // get a connection
            String url = "jdbc:mysql://localhost:3306/student_manager";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            // create sql to delete student
            String sql = "delete from feedback where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, feedBackId);

            // execute sql statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC code
            close(myConn, myStmt, null);
        }
    }
}
















