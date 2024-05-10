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

@WebServlet("/viewEventPlan")
public class viewEventPlan extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String eventId = request.getParameter("eventId");

        try {
            EventPlan eventPlan = EventPlanDBUtil.getEventPlanByEventId(Integer.parseInt(eventId));

            // Check if eventPlan is null
            if (eventPlan == null) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Sorry, the Event Plan has not been created yet. Please check again later.');");
                out.println("history.back();");
                out.println("</script>");
            } else {
                // Set the event plans as an attribute in the request
                request.setAttribute("eventPlan", eventPlan);

                // Forward the request to the JSP page for displaying
                request.getRequestDispatcher("viewEventPlan.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
