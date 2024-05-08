package Models.Event;

public class EventPlan {
    int eventPlanId;
    int eventId;
    double budget;
    String planDescription;

    public EventPlan() {
        this.eventPlanId = 0;
        this.eventId = 0;
        this.budget = 0;
        this.planDescription = "";
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
}

