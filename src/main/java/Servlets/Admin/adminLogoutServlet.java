package Servlets.Admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/adminLogoutServlet")
public class adminLogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            out.println("<script type='text/javascript'>");
            out.println("alert('You have been logged out');");
            out.println("location='Staff-Login.jsp'");
            out.println("</script>");

        } else {
            System.out.println("session is null");
        }
    }
}
