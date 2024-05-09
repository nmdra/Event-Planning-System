package Servlets.Event;

import Utils.Event.EventDBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteEvent")
public class DeleteEventServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Extract the event ID from request parameters

        String eventId = request.getParameter("eventId");

        // Attempt to delete the event
        boolean success = EventDBUtils.deleteEvent(eventId);

        // Send response indicating success or failure
        if (success) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Event deleted');");
            out.println("location='eventList'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Event could not be deleted');");
            out.println("location='eventList'");
            out.println("</script>");
        }
    }
}
