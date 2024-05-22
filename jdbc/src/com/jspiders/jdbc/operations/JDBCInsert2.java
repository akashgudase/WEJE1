package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert2 {

	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter user name");
		String name = scanner.nextLine();
		System.out.println("Enter email");
		String email = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		System.out.println("Enter mobile number");
		long mobile = scanner.nextLong();
		scanner.close();
		try {
			openConnection();
			query = "INSERT INTO user VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.setLong(5, mobile);
			int res = preparedStatement.executeUpdate();
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

	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weje1", "root", "root");
	}

	private static void closeConnection() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}

}
