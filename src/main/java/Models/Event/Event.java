package Models.Event;

public class Event {

    private int userID;
    private int eventId;
    private String location;
    private String category;
    private String attendees;
    private String requirements;
    private String dateTime;

    public Event() {
        this.userID = 0;
        this.eventId = 0;
        this.location = "";
        this.category = "";
        this.attendees = "";
        this.requirements = "";
        this.dateTime = "";
    }

    public Event(int userID, String location, String category, String attendees, String requirements, String dateTime) {
        this.userID = userID;
        this.location = location;
        this.category = category;
        this.attendees = attendees;
        this.requirements = requirements;
        this.dateTime = dateTime;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
