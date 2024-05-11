package Utils.Admin;

import Models.Staff.Admin;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDbUtil {
    public static Admin getAdmin(String username, String password) {
        Admin admin = null;
        try {
            Connection con = DBConnection.connectDB();

            PreparedStatement ps = con.prepareStatement("select * from admin Where username = ? AND password = ? AND position = 'admin'");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                admin = new Admin();
                admin.setAdminId(rs.getString(1));
                admin.setName(rs.getString(2));
                admin.setEmail(rs.getString(3));
                admin.setUsername(rs.getString(4));
                admin.setPosition(rs.getString(6));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return admin;
    }

    public static boolean addAdmin(Admin admin) {
        try (

                Connection con = DBConnection.connectDB();
                PreparedStatement statement = con.prepareStatement("INSERT INTO admin (name, email, username, password, position) VALUES (?, ?, ?, ?, ?)")
        ) {
            // Set the parameters for the prepared statement
            statement.setString(1, admin.getName());
            statement.setString(2, admin.getEmail());
            statement.setString(3, admin.getUsername());
            statement.setString(4, admin.getPassword());
            statement.setString(5, admin.getPosition());

            if (statement.executeUpdate() > 0) {
                System.out.println("User added successfully");
                return true;
            }

        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public static boolean deleteAdmin(int adminId) {
        boolean success=false;
        try (

                Connection con = DBConnection.connectDB();
                PreparedStatement statement = con.prepareStatement("DELETE FROM admin WHERE adminid = ?")
        ) {
            // Set the admin ID as a parameter for the prepared statement
            statement.setInt(1, adminId);

            // Execute the DELETE statement
            int rowsAffected=statement.executeUpdate();
            if(rowsAffected > 0) {
                success=true;
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return success;
    }

}
