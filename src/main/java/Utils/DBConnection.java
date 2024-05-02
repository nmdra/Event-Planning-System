package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//class used to make the database connection
public class DBConnection {
    public static Connection connectDB() throws ClassNotFoundException, SQLException {
        //database connection details
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        String dbName = "UserRegistrationDB";
        String dbUsername = "root";
        String dbPassword = "1111";

        //connecting the database
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL+dbName, dbUsername, dbPassword);
    }
}