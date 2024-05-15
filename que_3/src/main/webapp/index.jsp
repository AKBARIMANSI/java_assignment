<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Registration form</h1>	

	 <form action="StudentServlet" method="post">
		 
	        First Name: <input type="text" name="fname">
	        <br>
	        
	        Last Name: <input type="text" name="lname">
	        <br>
	        
	        Email: <input type="text" name="email">
	        <br>
	        
	        Mobile: <input type="text" name="mobile">
	        <br>
	        
	        Gender: <input type="radio" name="gender" value="Male"> Male
	                <input type="radio" name="gender" value="Female"> Female
	        <br>
	                
	        Password: <input type="password" name="password">
	        <br>
	        
	        <input type="submit" value="Submit">
        
  	  </form>
</body>
</html>