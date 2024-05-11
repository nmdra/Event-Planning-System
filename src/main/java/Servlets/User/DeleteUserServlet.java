package Servlets.User;

import Utils.User.UserDbUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteUser")
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Get the user ID parameter from the request
        String userId = request.getParameter("userId");

        // Call a method in your UserDbUtils class to delete the user
        boolean deleted = UserDbUtils.deleteUser(Integer.parseInt(userId));

        if (deleted) {
            out.println("<script type='text/javascript'>");
            out.println("alert('User deleted');");
            out.println("location='Register.jsp'");
            out.println("</script>");
        } else {
            // Redirect to an error page or display an error message
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
