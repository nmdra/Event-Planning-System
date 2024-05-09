package Servlets.EventPlan;

import Models.Event.EventPlan;
import Utils.EventPlan.EventPlanDBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EventPlanList")
public class EventPlanList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Fetch event plans from the database
            List<EventPlan> eventPlans = EventPlanDBUtil.getAllEventPlans();

            // Set the event plans as an attribute in the request
            request.setAttribute("eventPlans", eventPlans);

            // Forward the request to the JSP page for displaying
            request.getRequestDispatcher("EventPlanList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions or errors gracefully
            // Redirect to an error page or display an error message
            response.sendRedirect("error.jsp");
        }
    }
}
