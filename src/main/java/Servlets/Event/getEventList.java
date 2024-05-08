package Servlets.Event;

import Models.Event.Event;
import Utils.Event.EventDBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/eventList")
public class getEventList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            EventDBUtils eventDBUtils = new EventDBUtils();
            List<Event> events = eventDBUtils.getEventList();
            request.setAttribute("eventList", events);

            RequestDispatcher dispatcher = request.getRequestDispatcher("EventList.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            // You may want to handle the exception more gracefully
            // For example, redirect to an error page
        }
    }
}
