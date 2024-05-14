package Servlets.Admin;

import Models.Staff.Admin;
import Models.Staff.eventplanner;
import Utils.Admin.AdminDbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddStaffServlet")
public class AddStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Retrieve form parameters
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String position = request.getParameter("position");

        // Create Admin object with retrieved data
        eventplanner planner = new eventplanner();
        planner.setPlannerid(id);
        planner.setName(name);
        planner.setEmail(email);
        planner.setUsername(username);
        planner.setPassword(password);
        planner.setPosition(position);

        // Add admin to database
        if(AdminDbUtil.addStaff(planner)){
            out.println("<script type='text/javascript'>");
            out.println("alert('Staff Added Successfully');");
            out.println("location='staffList'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Unsuccessful Add Staff');");
            out.println("location='adminDashboard.jsp'");
            out.println("</script>");
        }
    }
}