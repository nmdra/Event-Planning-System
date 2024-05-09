package Utils.EventPlan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Event.EventPlan;
import Utils.DBConnection;

public class EventPlanDBUtil {

    // Method to add an event plan to the database
    public static boolean addEventPlan(EventPlan eventPlan) {
        // SQL query to insert a new event plan

        try {
            // Get a database connection
            Connection conn = DBConnection.connectDB();
            // Create a prepared statement with the SQL query
            PreparedStatement ps = conn.prepareStatement("INSERT INTO EventPlan (eventId, eventTheme, budget, planDescription) VALUES (?,?,?,?)");
            // Set values for the prepared statement parameters
            ps.setInt(1, eventPlan.getEventId());
            ps.setString(2, eventPlan.getTheme());
            ps.setDouble(3, eventPlan.getBudget());
            ps.setString(4, eventPlan.getPlanDescription());

            if (ps.executeUpdate() > 0) {
                System.out.println("Event added successfully");
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            // Handle any SQL errors
            e.printStackTrace();
        }
        return false;
    }

    public static List<EventPlan> getAllEventPlans() throws Exception {
        List<EventPlan> eventPlans = new ArrayList<>();

        try {
            // Establish connection with the database
           Connection con = DBConnection.connectDB();

            // Create a PreparedStatement object
            PreparedStatement ps = con.prepareStatement("SELECT * FROM EventPlan");

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // Iterate over the ResultSet and create EventPlan objects
            while (rs.next()) {
                EventPlan eventPlan = new EventPlan();
                eventPlan.setEventPlanId(rs.getInt("eventPlanId"));
                eventPlan.setEventId(rs.getInt("eventId"));
                eventPlan.setBudget(rs.getDouble("budget"));
                eventPlan.setPlanDescription(rs.getString("planDescription"));
                eventPlan.setTheme(rs.getString("eventTheme"));

                // Add the EventPlan object to the list
                eventPlans.add(eventPlan);
            }
        } finally {
            // Close resources in a finally block to ensure they're closed regardless of exceptions
        }

        return eventPlans;
    }

    public static boolean deleteEventPlan(String eventPlanId) {
        try {
            // Create connection with the database
            Connection con = DBConnection.connectDB();

            // Prepare the DELETE statement
            PreparedStatement ps = con.prepareStatement("DELETE FROM EventPlan WHERE eventPlanId = ?");

            // Set the eventId parameter
            ps.setInt(1, Integer.parseInt(eventPlanId));

            // Check if any rows were affected
            if (ps.executeUpdate() > 0) {
                System.out.println("Event Plan deleted successfully");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public static boolean updateEventPlan(EventPlan eventPlan) {
        try {
            // Create a connection to the database
            Connection con = DBConnection.connectDB();

            // Create a PreparedStatement object to execute the query
            PreparedStatement ps = con.prepareStatement("UPDATE EventPlan SET eventId=?, eventTheme=?, budget=?, planDescription=? WHERE eventPlanId=?");

            ps.setInt(5, eventPlan.getEventPlanId());
            ps.setInt(1, eventPlan.getEventId());
            ps.setString(2, eventPlan.getTheme());
            ps.setDouble(3, eventPlan.getBudget());
            ps.setString(4, eventPlan.getPlanDescription());

            if (ps.executeUpdate() > 0) {
                System.out.println("Event Plan updated successfully");
                return true;
            }
        }catch (SQLException | ClassNotFoundException e) {
                // Handle any SQL errors
                e.printStackTrace();
            }

        return false; // Update failed
    }

    public static EventPlan getEventPlanById(int eventPlanId) {
        EventPlan eventPlan = null;
        try {
            // Create a connection to the database
            Connection connection = DBConnection.connectDB();

            // Define the SQL query to select the event plan by ID
            String sql = "SELECT * FROM EventPlan WHERE eventPlanId=?";

            // Create a PreparedStatement object to execute the query
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, eventPlanId);

            // Execute the query and retrieve the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if the result set has any rows
            if (resultSet.next()) {
                // Extract data from the result set and create an EventPlan object
                eventPlan = new EventPlan();
                eventPlan.setEventPlanId(resultSet.getInt("eventPlanId"));
                eventPlan.setEventId(resultSet.getInt("eventId"));
                eventPlan.setTheme(resultSet.getString("eventTheme"));
                eventPlan.setBudget(resultSet.getDouble("budget"));
                eventPlan.setPlanDescription(resultSet.getString("planDescription"));
            }

            // Close the ResultSet, PreparedStatement, and connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return eventPlan;
    }
}
