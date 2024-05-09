package Servlets.Event;

import Models.Event.Event;
import Models.User;
import Utils.Event.EventDBUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/eventRequest")
public class EventRequest extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                int userID = user.getId();
                String category = request.getParameter("category");
                String dateTime = request.getParameter("dateTime");
                String attendance = request.getParameter("attendance");
                String location = request.getParameter("location");
                String requirements = request.getParameter("requirements");

                Event event = new Event(userID, location, category, attendance, requirements, dateTime);

//            out.println("<p>Category: " + category + "</p>");
//            out.println("<p>Date and Time: " + dateTime + "</p>");
//            out.println("<p>Attendance: " + attendance + "</p>");
//            out.println("<p>Location: " + location + "</p>");
//            out.println("<p>Requirements: " + requirements + "</p>");

                if (EventDBUtils.addEvent(event)) {
                    out.println("<script type='text/javascript'>");
                    out.println("alert('Event added to database.');");
                    out.println("location='eventList'");
                    out.println("</script>");
                } else {
                    out.println("<script type='text/javascript'>");
                    out.println("alert('Event not added to database.');");
                    out.println("location='eventRequest.jsp'");
                    out.println("</script>");
                }

            } else{
                out.println("<script type='text/javascript'>");
                out.println("alert('You Must Login First')");
                out.println("location='Login.jsp'");
                out.println("</script>");
            }
//
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
//        dispatcher.forward(request, response);

        } else {
            out.println("No session found.");
        }
    }
}


