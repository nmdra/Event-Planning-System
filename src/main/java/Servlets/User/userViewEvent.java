package Servlets.User;

import Models.Event.Event;
import Models.User;
import Utils.Event.EventDBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/viewEvent")
public class userViewEvent extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");

            if (user != null) {
                // Call DBUtils method to get event list by userID
                List<Event> eventList = EventDBUtils.getEventListByUserID(String.valueOf(user.getId()));

                // Set the eventList attribute in request
                request.setAttribute("eventList", eventList);

                // Forward the request to the event list JSP page
                request.getRequestDispatcher("/userEventList.jsp").forward(request, response);
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('You Must Login First');");
                out.println("location='Login.jsp';");
                out.println("</script>");
            }
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('You Must Login First');");
            out.println("location='Login.jsp';");
            out.println("</script>");
        }
    }
}
