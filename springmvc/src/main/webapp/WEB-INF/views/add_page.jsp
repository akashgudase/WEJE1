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
	<h1>IT'S AN ADD PAGE</h1>
	<div align="center">
		<form action="add_contact" method="post">
			<table>
				<tr>
					<td>FIRST NAME</td>
					<td><input type="text" name="firstName" required="required"></td>
				</tr>
				<tr>
					<td>LAST NAME</td>
					<td><input type="text" name="lastName" required="required"></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" name="email" required="required"></td>
				</tr>
				<tr>
					<td>MOBILE</td>
					<td><input type="text" name="mobile" required="required"></td>
				</tr>
			</table>
			<input type="submit" value="ADD">
		</form>
	</div>
</body>
</html>