package Servlets.Staff;

import Models.Staff.eventplanner;
import Utils.Staff.StaffDButil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Serial;

@WebServlet ("/deleteStaffAccount")
public class DeleteStaffAccountServlet extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String positionstaff = request.getParameter("position");

		if ("Planner".equals(positionstaff)) {

			String plannerid = request.getParameter("plannerid");

			boolean isTrue ;

			isTrue = StaffDButil.deletplanneraccount(plannerid);

			if(isTrue == true) {

				RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
				dis.forward(request, response);
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
	
    

