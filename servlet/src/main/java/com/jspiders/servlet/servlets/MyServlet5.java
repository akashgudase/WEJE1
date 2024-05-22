package com.jspiders.servlet.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/my_servlet5")
public class MyServlet5 implements Servlet {

	static {
		System.out.println("Servlet is loaded");
	}

	{
		System.out.println("Object is created");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() is invoked");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service() is invoked");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() is invoked");
	}

}
