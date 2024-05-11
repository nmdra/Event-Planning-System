package Utils.User;

import Models.User;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDbUtils {
    public static boolean addUser(User user) {

        try {
            //creating connection with the database
            Connection con = DBConnection.connectDB();

            PreparedStatement ps = con.prepareStatement("INSERT INTO users(NAME, EMAIL, USERNAME, PASSWORD) VALUES (?,?,?,?)");

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());

            if (ps.executeUpdate() > 0) {
                System.out.println("User added successfully");
                return true;
            }

        } catch (Exception se) {
            se.printStackTrace();
        }

        return false;
    }

    public static User validateLogin(String email, String password) {
        User user = null;

        try {
            Connection con = DBConnection.connectDB();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ? limit 1");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
//                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public static boolean deleteUser(int userId) {
        // Initialize database connection
        try (Connection connection = DBConnection.connectDB()) {
            // Prepare SQL statement to delete user
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if the user was successfully deleted
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle any database errors here
            return false;
        }
    }

    public static boolean updateUser(User user2) {

        try {
            //creating connection with the database
            Connection con = DBConnection.connectDB();

            PreparedStatement ps = con.prepareStatement("UPDATE UserRegistrationDB.users SET name = ?, email = ?, password = ? WHERE id = ? ");

            ps.setString(1, user2.getName());
            ps.setString(2, user2.getEmail());
            ps.setString(3, user2.getPassword());
            ps.setInt(4, user2.getId());

            if (ps.executeUpdate() > 0) {
                System.out.println("User Update successfully");
                return true;
            }

        } catch (Exception se) {
            se.printStackTrace();
        }

        return false;
    }
}
