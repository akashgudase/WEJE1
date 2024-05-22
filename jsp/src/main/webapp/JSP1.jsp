<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!int a = 0;
	int b = 1;
	int c = 0;%>
	<h1><%=a%></h1>
	<h1><%=b%></h1>
	<%
	for (int i = 1; i <= 8; i++) {
		c = a + b;
	%>
	<h1><%=c%></h1>
	<%
	a = b;
	b = c;
	}
	%>

</body>
</html>