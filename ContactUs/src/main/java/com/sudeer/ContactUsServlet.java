package com.sudeer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher requestdispatcher = request.getRequestDispatcher("contactus.jsp");
		requestdispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		String isActive = "false";

		Request userdata = new Request();

		userdata.setName(name);
		userdata.setEmail(email);
		userdata.setMessage(message);
		userdata.setIsActive(isActive);

		RequestDao userrequest = new RequestDao();
		try {
			userrequest.addUserRequest(userdata);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
