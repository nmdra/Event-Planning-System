package Servlets.Staff;

import Models.Staff.Admin;
import Models.Staff.eventplanner;
import Utils.Admin.AdminDbUtil;
import Utils.Staff.StaffDButil;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/staffLogin")
public class staffLoginServlet extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String position = request.getParameter("position");

		if("admin".equals(position)) {

			Admin adminDetails = AdminDbUtil.getAdmin(username, password);

			if (adminDetails != null) {
				HttpSession session = request.getSession();
				session.setAttribute("adminDetails", adminDetails);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
				dispatcher.forward(request, response);
			} else {

				out.println("<script type='text/javascript'>");
				out.println("alert('Your username or password is incorrect');");
				out.println("location='Staff-Login.jsp'");
				out.println("</script>");
			}

		}

		if("eventplanner".equals(position)) {

			eventplanner eventplanner_details= StaffDButil.geteventplanner(username, password, position);
			if (eventplanner_details != null) {
				HttpSession session = request.getSession();
				session.setAttribute("eventplanner_details", eventplanner_details);

				RequestDispatcher dispatcher = request.getRequestDispatcher("eventplannerDashboard.jsp");
				dispatcher.forward(request, response);
			} else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Your username or password is incorrect');");
				out.println("location='Staff-Login.jsp'");
				out.println("</script>");
			}

		}

	}

}

