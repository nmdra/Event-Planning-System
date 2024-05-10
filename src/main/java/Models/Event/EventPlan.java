package Models.Event;

public class EventPlan {

    private int userID;
    private int eventPlanId;
    private int eventId;
    private double budget;
    private String planDescription;
    private String theme;

    public EventPlan() {
        this.eventPlanId = 0;
        this.eventId = 0;
        this.budget = 0;
        this.planDescription = "";
        this.theme = "";
        this.userID = 0;
    }

    public EventPlan(int eventPlanId, int eventId, double budget, String planDescription, String theme,int userID) {
        this.eventPlanId = eventPlanId;
        this.eventId = eventId;
        this.budget = budget;
        this.planDescription = planDescription;
        this.theme = theme;
        this.userID = userID;
    }

    public EventPlan(int eventId, double budget, String planDescription, String theme, int userID) {
        this.eventId = eventId;
        this.budget = budget;
        this.planDescription = planDescription;
        this.theme = theme;
        this.eventPlanId = 0;
        this.userID = userID;
    }

    public int getEventPlanId() {
        return eventPlanId;
    }

    public void setEventPlanId(int eventPlanId) {
        this.eventPlanId = eventPlanId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

