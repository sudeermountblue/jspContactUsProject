package com.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("login.jsp");
		requestdispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("password");

		User user = new User();

		user.setUsername(username);
		user.setPassword(password);

		UserDao userdao = new UserDao();
		try {
			if (userdao.checkCredentials(user)) {

				response.sendRedirect("dashboard");
			} else {
				response.sendRedirect("login.jsp");
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

}
