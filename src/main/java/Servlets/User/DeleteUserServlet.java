package Servlets.User;

import Utils.UserDbUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the user ID parameter from the request
        String userId = request.getParameter("userId");

        // Call a method in your UserDbUtils class to delete the user
        boolean deleted = UserDbUtils.deleteUser(Integer.parseInt(userId));

        if (deleted) {
            // Redirect to a success page or display a success message
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        } else {
            // Redirect to an error page or display an error message
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
