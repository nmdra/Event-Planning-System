package Servlets.User;

import Models.User;
import Utils.UserDbUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet ("/LoginServlet")
public class userLoginServlet extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User usr = (UserDbUtils.validateLogin(username, password));

		if (usr != null) {
			try {

				HttpSession session = request.getSession();
				session.setAttribute("user", usr);

				response.sendRedirect(request.getContextPath() + "/index.jsp");

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

