<html>
<body>
	<%
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("signin_page");
	requestDispatcher.forward(request, response);
	%>
</body>
</html>
