package com.login;

import com.sudeer.Request;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sudeer.RequestDao;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDao dao = new RequestDao();
		try {
			ArrayList<Request> archiveList = dao.getArchiveRequests();

			ArrayList<Request> activeList = dao.getActiveRequests();
			request.setAttribute("archiveList", archiveList);

			request.setAttribute("activeList", activeList);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher requestdispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestdispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		response.getWriter().println(id);

		RequestDao dao = new RequestDao();

		try {
			dao.changeActiveStatus(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<Request> archiveList = dao.getArchiveRequests();

			ArrayList<Request> activeList = dao.getActiveRequests();
			request.setAttribute("archiveList", archiveList);

			request.setAttribute("activeList", activeList);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher requestdispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestdispatcher.forward(request, response);

	}

}
