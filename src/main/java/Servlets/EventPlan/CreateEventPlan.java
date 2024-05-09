package Servlets.EventPlan;

import Models.Event.EventPlan;
import Utils.EventPlan.EventPlanDBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/createPlan")
public class CreateEventPlan extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Retrieve form data from the request
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        double budget = Double.parseDouble(request.getParameter("budget"));
        String planDescription = request.getParameter("planDescription");
        String theme = request.getParameter("theme");

        System.out.println(eventId + " " + budget + " " + planDescription + " " + theme);

        // Create an EventPlan object with the retrieved data
        EventPlan eventPlan = new EventPlan(eventId,budget,planDescription, theme);

        // Add the event plan to the database using the EventPlanDBUtil class
        boolean success = EventPlanDBUtil.addEventPlan(eventPlan);

        // Redirect the user based on the result of the insertion
        if (success) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Event Plan Created');");
            out.println("location='EventPlanList'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Error Creating Event Plan');");
            out.println("location='eventList'");
            out.println("</script>");
        }
    }
}
