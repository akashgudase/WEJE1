<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
/* Style for the entire page */
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f7f7f7;
	margin: 0;
	padding: 0;
}

/* Style for the navigation links */
nav {
	text-align: center;
	margin-bottom: 20px;
}

nav a {
	text-decoration: none;
	color: #fff;
	padding: 10px 20px;
	margin: 0 5px;
	border-radius: 5px;
	background-color: #4CAF50;
	transition: background-color 0.3s ease;
}

nav a:hover {
	background-color: #45a049;
}

/* Style for the page-level div */
div {
	text-align: center;
	margin: 20px auto; /* Center the div */
}

/* Style for the h1 header */
h1 {
	color: #333;
	font-size: 32px;
	margin-bottom: 20px;
	text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>
	<div align="center">
		<nav>
			<a href="add_page">ADD</a> <a href="contacts_page">CONTACTS</a> <a
				href="edit_page">EDIT</a> <a href="delete_page">DELETE</a> <a
				href="signout">SIGN OUT</a><a href="delete_user">DELETE USER</a>
		</nav>
		<h1>WELCOME TO CONTACT MANAGER APPLICATION</h1>
	</div>
</body>
</html>