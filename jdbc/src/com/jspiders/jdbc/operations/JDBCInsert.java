package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert {

	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;

	public static void main(String[] args) {

		try {
			openConnection();
			statement = connection.createStatement();
			query = "INSERT INTO user VALUES(2, 'Ramesh', 'ramesh@gmail.com', 'Ramesh@1234', 9876543211)";
			boolean res = statement.execute(query);
			System.out.println(res);
			System.out.println("Data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void openConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weje1?user=root&&password=root");

	}

	private static void closeConnection() throws SQLException {
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}

}
