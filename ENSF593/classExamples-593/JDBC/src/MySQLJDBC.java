
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class MySQLJDBC implements IDBCredentials {

    // Attributes
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public void initializeConnection() {
        try {
            //Register JDBC driver
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            //Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Problem");
            e.printStackTrace();
        }

    }

    public void close() {
        try {
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser() {
        try {
            stmt = conn.createStatement();
            String insert = "INSERT INTO STUDENT (ID, first, last) values (11, 'Joe','Jones')";
            int rowCount = stmt.executeUpdate(insert);
            System.out.println("row Count = " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        String sql = "CREATE TABLE STUDENT " + "(id INTEGER not NULL, " + " first VARCHAR(255), "
                + " last VARCHAR(255), " + " PRIMARY KEY ( id ))";

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Created table in given database...");
    }

    public static void main(String[] args0) {
        MySQLJDBC myApp = new MySQLJDBC();
        myApp.initializeConnection();
//        myApp.createTable();
        myApp.insertUser();
        //myApp.close();
    }

}