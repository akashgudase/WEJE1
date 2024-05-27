<%@page import="com.jspiders.springmvc.dto.ContactDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
a {
	text-decoration: none;
	color: #4CAF50;
	padding: 10px 20px;
	margin-top: 0px;
	margin-right: 0px;
	border: 2px solid #4CAF50;
	border-radius: 5px;
	transition: background-color 0.3s, color 0.3s, border-color 0.3s;
	background-color: #4CAF50;
	color: white;
}

#home {
	margin-right: -275px;
	margin-top: 30px;
}

/* Style for the entire page */
body {
	font-family: Arial, sans-serif;
	background-color: #f7f7f7;
	margin: 0;
	padding: 0;
}

/* Style for the form container */

/* Style for the form title */
h2 {
	color: #333;
	margin-bottom: 20px;
}

/* Style for the form elements */
form {
	display: flex;
	flex-direction: column;
	align-items: center;
}

div {
	text-align: center;
	margin: 20px auto; /* Center the div */
	width: 50%;
	padding: 20px;
	border-radius: 10px;
}

label {
	margin-bottom: 10px;
	color: #333;
}

input[type="text"] {
	width: 96.5%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	margin-bottom: 10px;
}

input[type="submit"] {
	width: 100%;
	padding: 12px;
	border: none;
	border-radius: 5px;
	background-color: #e74c3c;
	color: white;
	cursor: pointer;
	transition: background-color 0.3s ease;
	font-size: 15px;
}

input[type="submit"]:hover {
	background-color: #c0392b;
}
/* Style for the entire page */
body {
	font-family: Arial, sans-serif;
	background-color: #f7f7f7;
	margin: 0;
	padding: 0;
}

/* Style for the page-level div */
div {
	text-align: center;
	margin: 20px auto; /* Center the div */
}

/* Style for the h2 header */
h2 {
	color: #333;
	margin-bottom: 20px;
}

/* Style for the table */
table {
	width: 80%;
	margin: 0 auto;
	border-collapse: collapse;
}

/* Style for table headers */
th {
	background-color: #4CAF50;
	color: white;
	padding: 10px 15px;
}

/* Style for table data cells */
td {
	border: 1px solid #ddd;
	padding: 10px 15px;
}

/* Alternate row background color */
tr:nth-child(even) {
	background-color: #f2f2f2;
}

/* Style for the h3 header */
h3 {
	color: #333;
}
</style>
</head>
<body>
	<div id="home">
		<a href="home_page">HOME</a>
	</div>
	<div align="center">
		<h2>DELETE CONTACT</h2>
		<form action="delete_contact">
			<label>ENTER ID</label> <input type="text" name="id"
				required="required"> <input type="submit" value="DELETE">
		</form>
	</div>
	<%
	@SuppressWarnings("unchecked")
	List<ContactDTO> contacts = (List<ContactDTO>) request.getAttribute("contacts");
	if (contacts != null) {
	%>
	<div align="center">
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
	</div>
	<%
	}
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<div align="center">
		<h3><%=message%></h3>
	</div>
	<%
	}
	%>
</body>
</html>