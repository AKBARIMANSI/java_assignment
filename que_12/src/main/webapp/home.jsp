<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
           <%
          String uname = (String)session.getAttribute("uname");
          if(uname==null)
          {
        	 request.setAttribute("err","please login first...");
        	 request.getRequestDispatcher("login.jsp").forward(request,response);
       	   }
          %>
          
        <h1>Home</h1>
        <h2>Welcome ,<%=uname%></h2>
        <h3><a href = "dispaly">View all data</a></h3>
</body>
</html>