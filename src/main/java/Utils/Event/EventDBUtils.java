package Utils.Event;

import Models.Event.Event;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDBUtils {
    public static boolean addEvent(Event event){

        try {
            //creating connection with the database
            Connection con = DBConnection.connectDB();

            PreparedStatement ps = con.prepareStatement("INSERT INTO Event (userId, category, location, datetime, specialReq, attendees) values (?,?,?,?,?,?)");

            ps.setInt(1, event.getUserID());
            ps.setString(2, event.getCategory());
            ps.setString(3, event.getLocation());
            ps.setString(4, event.getDateTime());
            ps.setString(5, event.getRequirements());
            ps.setString(6, event.getAttendees());

            if (ps.executeUpdate() > 0) {
                System.out.println("Event added successfully");
                return true;
            }

        } catch (Exception se) {
            se.printStackTrace();
        }

        return false;
    }

    public List<Event> getEventList() {

        List<Event> eventRequests = new ArrayList<>();

        try {
            Connection con = DBConnection.connectDB();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Event ORDER BY eventId ASC");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                int eventID = rs.getInt("eventId");
                int userID = rs.getInt("userId");
                String category = rs.getString("category");
                String location = rs.getString("location");
                String datetime = rs.getString("datetime");
                String req = rs.getString("specialReq");
                String attendees = rs.getString("attendees");


                Event event = new Event(eventID, userID, location, category,attendees, req, datetime);

                eventRequests.add(event);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return eventRequests;
    }

    public static List<Event> getEventListByUserID(String userID) {
        List<Event> eventList = new ArrayList<>();

        try {
            Connection con = DBConnection.connectDB();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Event WHERE userID = ?");

            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Event event = new Event();
                event.setEventId(rs.getInt("eventId"));
                event.setUserID(rs.getInt("userID"));
                event.setCategory(rs.getString("category"));
                event.setLocation(rs.getString("location"));
                event.setDateTime(rs.getString("datetime"));
                event.setRequirements(rs.getString("specialReq"));
                event.setAttendees(rs.getString("attendees"));

                eventList.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return eventList;
    }

    public static boolean deleteEvent(String eventId) {
        try {
            // Create connection with the database
            Connection con = DBConnection.connectDB();

            // Prepare the DELETE statement
            PreparedStatement ps = con.prepareStatement("DELETE FROM Event WHERE eventId = ?");

            // Set the eventId parameter
            ps.setInt(1, Integer.parseInt(eventId));


            // Check if any rows were affected
            if (ps.executeUpdate() > 0) {
                System.out.println("Event deleted successfully");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
