package Servlets.Admin;

import Models.Event.Event;
import Models.User;
import Utils.Admin.AdminDbUtil;
import Utils.Event.EventDBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/userList")
public class getUsersList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            AdminDbUtil adminDbUtil = new AdminDbUtil();
            List<User> users = adminDbUtil.getUserList();
            request.setAttribute("userList", users);

            RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            // You may want to handle the exception more gracefully
            // For example, redirect to an error page
        }
    }
}
