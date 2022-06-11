package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class UserDao {

	String sqlQuery = "select * from login where username=? and password=?";

	public boolean checkCredentials(User user) throws ClassNotFoundException {

		try {

			PreparedStatement statement = GetConnection.getconnection().prepareStatement(sqlQuery);

			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

}
