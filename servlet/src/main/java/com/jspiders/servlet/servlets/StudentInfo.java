package com.jspiders.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.servlet.entity.Student;
import com.jspiders.servlet.jdbc.StudentJDBC;

@WebServlet("/student")
public class StudentInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		int res = StudentJDBC.addStudent(id, name, email, mobile);
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if(res == 1) {
			writer.println("<h1>Student added</h1>");
		}else {
			writer.println("<h1>Student not added</h1>");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> students = StudentJDBC.findAllStudents();
		if(students != null && students.size() > 0) {
			req.setAttribute("list", students);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("student_info.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			writer.println("<h1>Students not found</h1>");
		}
	}

}
