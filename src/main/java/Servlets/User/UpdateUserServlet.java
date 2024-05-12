package Servlets.User;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Models.User;
import Utils.User.UserDbUtils;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        User user = null;

        HttpSession session = request.getSession(false);
        if (session != null) {
            user = (User) session.getAttribute("user");
        }
        assert user != null;
        int userId = user.getId(); // Assuming you have a hidden input field in your form to store the user2 ID
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user2 = new User(userId,name,email,username,password);

        if (UserDbUtils.updateUser(user2)) {
            out.println("<script type='text/javascript'>");
            out.println("alert('User details updated successfully. Please Login.');");
            out.println("location='Login.jsp'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Failed to update User details. Please try again');");
            out.println("location='userProfile.jsp'");
            out.println("</script>");
        }
    }
}
