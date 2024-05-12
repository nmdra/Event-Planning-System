package Servlets.Admin;

import Models.Staff.eventplanner;
import Utils.Admin.AdminDbUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/staffList")
public class staffListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
        	
        	//check here
            List<eventplanner> eventplanner = AdminDbUtil.getStaffList();

            //check here
            request.setAttribute("eventplanners", eventplanner);

            request.getRequestDispatcher("staffList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
