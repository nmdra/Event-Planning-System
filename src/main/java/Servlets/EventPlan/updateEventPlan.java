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
import java.util.List;

@WebServlet("/updateEventPlan")
public class updateEventPlan extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String eventPlanId = request.getParameter("eventPlanId");

        try {
            // Fetch event plans from the database
            EventPlan eventPlan = EventPlanDBUtil.getEventPlanById(Integer.parseInt(eventPlanId));

            // Set the event plans as an attribute in the request
            request.setAttribute("eventPlan", eventPlan);

            // Forward the request to the JSP page for displaying
            request.getRequestDispatcher("updateEventPlan.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions or errors gracefully
            // Redirect to an error page or display an error message
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Retrieve form data from the request
        int userId = Integer.parseInt(request.getParameter("userID"));
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        int eventPlanId = Integer.parseInt(request.getParameter("eventPlanId"));
        double budget = Double.parseDouble(request.getParameter("budget"));
        String planDescription = request.getParameter("planDescription");
        String theme = request.getParameter("theme");

        System.out.println(eventId + " " + budget + " " + planDescription + " " + theme);

        // Create an EventPlan object with the updated details
        EventPlan eventPlan = new EventPlan(eventPlanId,eventId,budget,planDescription,theme,userId);

        // Call the method to update the event plan in the database
        boolean success = EventPlanDBUtil.updateEventPlan(eventPlan);

        // Redirect back to the event plan list page
        if (success) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Event Plan Updated');");
            out.println("location='EventPlanList'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Event Plan Not Updated');");
            out.println("location='eventPlanList'");
            out.println("</script>");
        }
    }
}
