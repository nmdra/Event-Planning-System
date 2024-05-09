package Servlets.EventPlan;

import Utils.Event.EventDBUtils;
import Utils.EventPlan.EventPlanDBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteEventPlan")
public class DeleteEventPlan extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Extract the event ID from request parameters

        String eventPlanId = request.getParameter("eventPlanId");

        // Attempt to delete the event
        boolean success = EventPlanDBUtil.deleteEventPlan(eventPlanId);

        // Send response indicating success or failure
        if (success) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Event Plan deleted');");
            out.println("location='EventPlanList'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Event Plan could not be deleted');");
            out.println("location='EventPlanList'");
            out.println("</script>");
        }
    }
}