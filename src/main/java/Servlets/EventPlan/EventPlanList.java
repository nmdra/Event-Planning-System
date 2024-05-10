package Servlets.EventPlan;

import Models.Event.EventPlan;
import Utils.EventPlan.EventPlanDBUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EventPlanList")
public class EventPlanList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<EventPlan> eventPlans = EventPlanDBUtil.getAllEventPlans();

            request.setAttribute("eventPlans", eventPlans);

            request.getRequestDispatcher("EventPlanList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
