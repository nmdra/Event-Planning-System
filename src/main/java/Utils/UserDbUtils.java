package Utils;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDbUtils {
    public static boolean addUser(User user) {

        try {
            //creating connection with the database
            Connection con = DBConnection.connectDB();

            PreparedStatement ps = con.prepareStatement("INSERT INTO users(name, email, username, password) values (?,?,?,?)");

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());

            if (ps.executeUpdate() > 0) {
                return false;
            }

        } catch (Exception se) {
            se.printStackTrace();
        }

        return true;
    }

    public static User validateLogin(String email, String password) {
        User user = null;

        try {
            Connection con = DBConnection.connectDB();
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
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
}
