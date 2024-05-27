<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
/* Center the form */
div {
	text-align: center;
}

/* Style the form header */
h2 {
	font-size: 28px;
	color: #333;
	margin-bottom: 20px;
}

/* Style the table */
table {
	margin: 0 auto 20px auto;
	border-collapse: collapse;
	width: 300px;
}

/* Style table cells */
td {
	padding: 10px;
}

/* Style the input fields */
input[type="text"], input[type="password"] {
	padding: 10px;
	width: 100%;
	border: 1px solid #ccc;
	border-radius: 6px;
	box-sizing: border-box;
	font-size: 16px;
	margin-bottom: 10px;
}

/* Style the submit button */
input[type="submit"] {
	padding: 12px 24px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	font-size: 16px;
}

/* Change submit button color on hover */
input[type="submit"]:hover {
	background-color: #45a049;
}

/* Style the message */
h3 {
	color: #f00;
	margin-top: 10px;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div align="center">
		<h2>SIGN IN</h2>
		<form action="check_user" method="post">
			<table>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" name="email" required="required"></td>
				</tr>
				<tr>
					<td>PASSWORD</td>
					<td><input type="text" name="password" required="required"></td>
				</tr>
			</table>
			<input type="submit" value="SIGN IN">
		</form>
		<h4>
			New user?<a href="signup_page">Sign up</a>
		</h4>
	</div>
	<%
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