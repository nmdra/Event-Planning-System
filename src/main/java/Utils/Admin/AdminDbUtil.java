package Utils.Admin;

import Models.Staff.Admin;
import Models.Staff.eventplanner;
import Models.User;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<eventplanner> getStaffList() {
        List<eventplanner> staffList = new ArrayList<>();

        try {
            Connection con = DBConnection.connectDB();

            PreparedStatement ps = con.prepareStatement("select * from eventplanner");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                eventplanner staff = new eventplanner();
                staff.setPlanner(rs.getString(1));
                staff.setName(rs.getString(2));
                staff.setEmail(rs.getString(3));
                staff.setUsername(rs.getString(4));
                staff.setPosition(rs.getString(6));

                staffList.add(staff);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return staffList;

    }


    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        try {
            Connection con = DBConnection.connectDB();

            PreparedStatement ps = con.prepareStatement("select * from users");
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String position = rs.getString(4);
                String email = rs.getString(5);

                User user = new User(userId, username, password, position, email);

                userList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    public static boolean addStaff(eventplanner planner) {

        try {
            //creating connection with the database
            Connection con = DBConnection.connectDB();

            PreparedStatement ps = con.prepareStatement("INSERT INTO eventplanner(plannerid, name, email, username, password, position) values (?,?,?,?,?,?)");

            ps.setString(1, planner.getPlannerid());
            ps.setString(2, planner.getName());
            ps.setString(3, planner.getEmail());
            ps.setString(4, planner.getUsername());
            ps.setString(5, planner.getPassword());
            ps.setString(6, planner.getPosition());

            if (ps.executeUpdate() > 0) {
                System.out.println("Planner added successfully");
                return true;
            }

        } catch (Exception se) {
            se.printStackTrace();
        }

        return false;
    }


}


