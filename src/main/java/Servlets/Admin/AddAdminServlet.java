package Servlets.Admin;

import Models.Staff.Admin;
import Utils.Admin.AdminDbUtil;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String position = request.getParameter("position");
        
        // Create Admin object with retrieved data
        Admin admin = new Admin();
        admin.setName(name);
        admin.setEmail(email);
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setPosition(position);
        
        // Add admin to database
        if(AdminDbUtil.addAdmin(admin)){
            out.println("<script type='text/javascript'>");
            out.println("alert('Admin Added Successfully');");
            out.println("location='adminDashboard.jsp'");
            out.println("</script>");
        }
    }
}