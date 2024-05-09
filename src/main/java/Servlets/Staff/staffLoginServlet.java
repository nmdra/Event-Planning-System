package Servlets.Staff;

import Models.Staff.eventplanner;
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


		boolean isTrue ;

		isTrue = StaffDButil.validatelogin(username, password,position);

		if(isTrue == true) {

			HttpSession session1 = request.getSession(true);
			session1.setAttribute("username", username);
			session1.setAttribute("password", password);
			session1.setAttribute("position", position);


			if("admin".equals(position)) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
				dispatcher.forward(request, response);
			}


			if("eventplanner".equals(position)) {

				try {

					String loggingSuccess = "Logging Success!";
					request.setAttribute("loginMsg", loggingSuccess);

					eventplanner eventplanner_details= StaffDButil.geteventplanner(username, password, position);

					HttpSession session = request.getSession();
					session.setAttribute("eventplanner_details", eventplanner_details);

					RequestDispatcher dispatcher = request.getRequestDispatcher("eventplannerDashboard.jsp");
					dispatcher.forward(request, response);



				} catch (Exception e) {

					e.printStackTrace();

				}


			}

		}

		else {

			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='Login.jsp'");
			out.println("</script>");
		}

	}

}
