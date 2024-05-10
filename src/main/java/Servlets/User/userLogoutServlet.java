package Servlets.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LogoutServlet")
public class userLogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            out.println("<script type='text/javascript'>");
            out.println("alert('You have been logged out');");
            out.println("location='Login.jsp'");
            out.println("</script>");

//            response.sendRedirect(request.getContextPath() + "/Login.jsp");
        } else {
            System.out.println("session is null");
        }
    }
}
