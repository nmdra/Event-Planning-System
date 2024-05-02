package Servlets;

import Models.User;
import Utils.UserDbUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User usr = (UserDbUtils.validateLogin(username, password));

		if (usr != null) {
			out.println(usr.getEmail());
			try {

				String loggingSuccess = "Logging Success!";
				request.setAttribute("loginMsg", loggingSuccess);

				HttpSession session = request.getSession();
				session.setAttribute("user", usr);

				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);

			} catch (Exception e) {

				e.printStackTrace();

			}

		} else {

			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='Login.jsp'");
			out.println("</script>");
		}

	}
}

