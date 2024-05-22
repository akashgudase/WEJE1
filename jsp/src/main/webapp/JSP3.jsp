<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!List<Integer> list;%>
	<%
	list = new ArrayList<Integer>();
	list.add(10);
	list.add(20);
	list.add(30);
	list.add(40);
	list.add(50);
	for (Integer value : list) {
	%>
	<h1><%=value%></h1>
	<%
	}
	%>
</body>
</html>