package Servlets.User;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Models.User;
import Utils.User.UserDbUtils;

@WebServlet("/userRegister")
public class userRegister extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        User usr = new User(name, email, username, pass);

        if(UserDbUtils.addUser(usr)){
            out.println("<script type='text/javascript'>");
            out.println("alert('Account Created. Please Login');");
            out.println("location='Login.jsp'");
            out.println("</script>");
        };

//        request.setAttribute("user", usr);
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
//        dispatcher.forward(request, response);
    }
}

