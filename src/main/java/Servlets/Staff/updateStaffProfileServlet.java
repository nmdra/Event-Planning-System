package Servlets.Staff;

import Models.Staff.eventplanner;
import Utils.Staff.StaffDButil;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet ("/updateStaffProfile")
public class updateStaffProfileServlet extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String positionstaff = request.getParameter("position");
		System.out.println("test"+positionstaff);

		if ("eventplanner".equals(positionstaff)) {

			String plannerid = request.getParameter("plannerid");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String position = request.getParameter("position");
			String username = request.getParameter("username");

			boolean isTrue ;

			isTrue = StaffDButil.updateplannerprofile(plannerid, name, email,username);

			if(isTrue == true) {
				eventplanner eventplanner_details = StaffDButil.getplannerDeatials(plannerid);

				HttpSession session = request.getSession();
				session.setAttribute("eventplanner_details", eventplanner_details);

				request.setAttribute("updateMessage", "Update was successful.");

				out.println("<script type='text/javascript'>");
				out.println("alert('Update Successful');");
				out.println("location='staffList'");
				out.println("</script>");
//				RequestDispatcher dis = request.getRequestDispatcher("eventplannerprofile.jsp");
//				dis.forward(request, response);
			}

			else {
				eventplanner eventplanner_details = StaffDButil.getplannerDeatials(plannerid);

				HttpSession session = request.getSession();
				session.setAttribute("eventplanner_details", eventplanner_details);

				request.setAttribute("updateMessage", "Update was unsuccessful.");

				RequestDispatcher dis = request.getRequestDispatcher("eventplannerprofile.jsp");
				dis.forward(request, response);
			}
		}

		else {
			System.out.println("unsuccessful");
		}
	}
}
