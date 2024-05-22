<%@page import="com.jspiders.springmvc.dto.ContactDTO"%>
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
	<a href="home_page">HOME</a>
	<h1>IT'S A CONTACTS PAGE</h1>
	<%
	@SuppressWarnings("unchecked")
	List<ContactDTO> contacts = (List<ContactDTO>) request.getAttribute("contacts");
	if (contacts != null) {
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>FIRST NAME</th>
			<th>LAST NAME</th>
			<th>EMAIL</th>
			<th>MOBILE</th>
		</tr>
		<%
		for (ContactDTO contact : contacts) {
		%>
		<tr>
			<td><%=contact.getId()%></td>
			<td><%=contact.getFirstName()%></td>
			<td><%=contact.getLastName()%></td>
			<td><%=contact.getEmail()%></td>
			<td><%=contact.getMobile()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<h2>
		<%=message%>
	</h2>
	<%
	}
	%>
</body>
</html>