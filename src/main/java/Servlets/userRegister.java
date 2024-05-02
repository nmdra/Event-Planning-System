package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Models.User;
import Utils.UserDbUtils;

@WebServlet("/userRegister")
public class userRegister extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        User usr = new User(name, username,email,pass);

        if(UserDbUtils.addUser(usr)){
            out.println("User Successfully added to database.");
        };

        request.setAttribute("user", usr);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
        dispatcher.forward(request, response);
    }
}

