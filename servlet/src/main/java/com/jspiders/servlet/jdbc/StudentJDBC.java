package com.jspiders.servlet.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspiders.servlet.entity.Student;

public class StudentJDBC {

	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;

	public static int addStudent(int id, String name, String email, long mobile) {
		int res = 0;
		try {
			openConnection();
			query = "INSERT INTO student VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setLong(4, mobile);
			res = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public static List<Student> findAllStudents(){
		List<Student> students = new ArrayList<>();
		try {
			openConnection();
			query = "SELECT * FROM student";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				student.setMobile(resultSet.getLong(4));
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}

	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weje1", "root", "root");
	}

	private static void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
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
