package com.sudeer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class GetConnection {

	static String url = "jdbc:postgresql://localhost:5432/ContactUsApp";
	static String Username = "postgres";
	static String Password = "Sudeer@7904";

	public static Connection getconnection() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, Username, Password);
			return connection;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;

	}
}

public class RequestDao {

	public int addUserRequest(Request user) throws SQLException {

		String name = user.getName();
		String email = user.getEmail();
		String message = user.getMessage();
		String isactive = user.getIsActive();

		String sqlQuery = String.format(
				"INSERT INTO contactus(name,email,message,isactive) VALUES('%s','%s','%s','%s')", name, email, message,
				isactive);

		Statement statement = GetConnection.getconnection().createStatement();
		return statement.executeUpdate(sqlQuery);

	}

	public void changeActiveStatus(int queryId) throws SQLException {

		String sqlQuery = String.format("update contactus set isactive='true' where id=%s", queryId);

		Statement statement = GetConnection.getconnection().createStatement();

		statement.executeQuery(sqlQuery);

	}

	public ArrayList<Request> getArchiveRequests() throws SQLException {
		String sqlQuery = "select * from contactus where isactive='true'";

		Statement statement = GetConnection.getconnection().createStatement();
		ResultSet resultset = statement.executeQuery(sqlQuery);
		ArrayList<Request> archivedList = new ArrayList();
		while (resultset.next()) {
			Request request = new Request();
			request.setId(resultset.getInt(1));
			request.setName(resultset.getString(2));
			request.setEmail(resultset.getString(3));
			request.setMessage(resultset.getString(4));
			request.setIsActive(resultset.getString(5));

			archivedList.add(request);

		}
		return archivedList;

	}

	public ArrayList<Request> getActiveRequests() throws SQLException {
		String sqlQuery = "select * from contactus where isactive='false';";

		Statement statement = GetConnection.getconnection().createStatement();
		ResultSet resultset = statement.executeQuery(sqlQuery);
		ArrayList<Request> activeList = new ArrayList();
		while (resultset.next()) {
			Request request = new Request();
			request.setId(resultset.getInt(1));
			request.setName(resultset.getString(2));
			request.setEmail(resultset.getString(3));
			request.setMessage(resultset.getString(4));
			request.setIsActive(resultset.getString(5));

			activeList.add(request);

		}
		return activeList;

	}

}