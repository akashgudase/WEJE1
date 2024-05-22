package com.jspiders.jdbc.operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUpdate {

	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;

	public static void main(String[] args) {
		try {
			openConnection();
			statement = connection.createStatement();
	query = "UPDATE user SET password = 'Suresh@4567' WHERE id = 1";
			int res = statement.executeUpdate(query);
			System.out.println(res + " row(s) affected");
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

	private static void openConnection() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		File file = new File("D://File//db_info.txt");
		FileReader fileReader = new FileReader(file);
		Properties properties = new Properties();
		properties.load(fileReader);
		connection = DriverManager.
		getConnection(properties.getProperty("url"), properties);
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
