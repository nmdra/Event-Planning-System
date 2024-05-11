package Servlets.Admin;

import Utils.Admin.AdminDbUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the admin ID from the request parameters
        int adminId = Integer.parseInt(request.getParameter("Id"));

        // Call a method to delete the admin from the database
        boolean success = false;
        
			success = AdminDbUtil.deleteAdmin(adminId);

        if (success) {
            // Redirect back to the admin dashboard if deletion was successful
            response.sendRedirect(request.getContextPath() + "/adminDashboard.jsp");
        } else {
            // Handle deletion failure, perhaps by displaying an error message
            // You can also redirect the user back to the admin dashboard with an error parameter
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
	  
}
}