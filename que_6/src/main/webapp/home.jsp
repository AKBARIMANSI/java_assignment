<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<%
	String uname = (String) session.getAttribute("uname");
	if (uname == null) {
		request.setAttribute("err", "please login first...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	%>

	<h1>Home</h1>
	<h2>
		Welcome,<%=uname%></h2>
	<h3>
		<a href="display">View All Data</a>
	</h3>
</body>
</html>