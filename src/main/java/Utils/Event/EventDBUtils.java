package Utils.Event;

import Models.Event.Event;
import Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventDBUtils {
    public static boolean addEvent(Event event){

        try {
            //creating connection with the database
            Connection con = DBConnection.connectDB();

            PreparedStatement ps = con.prepareStatement("INSERT INTO requestEvent (userId, category, location, datetime, specialReq, attendees) values (?,?,?,?,?,?)");

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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM requestEvent ORDER BY eventId DESC");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                int eventID = rs.getInt("eventId");
                int userID = rs.getInt("userId");
                String category = rs.getString("category");
                String location = rs.getString("location");
                String datetime = rs.getString("datetime");
                String req = rs.getString("specialReq");
                String attendees = rs.getString("attendees");


                Event event = new Event(userID, location, category,attendees, req, datetime);

                eventRequests.add(event);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return eventRequests;
    }
}
