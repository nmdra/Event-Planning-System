import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/OOPTest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";

    public static void main(String[] args) {
        // Establishing a connection
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                // Creating a statement
                Statement stmt = conn.createStatement();

                // Executing a query
                String query = "SELECT * FROM sample_table";
                ResultSet rs = stmt.executeQuery(query);

                // Processing the result set
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    // Do something with the data
                    System.out.println("ID: " + id + ", Name: " + name);
                }

                // Closing resources
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
