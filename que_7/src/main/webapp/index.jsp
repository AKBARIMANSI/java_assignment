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
		  
		<form action="SaveServlet" method="post">
		  
		<table>  
		
			<tr><td>FirstName:</td><td>
			<input type="text" name="name"/>
			</td></tr>
			
			<tr><td>LastName:</td><td>
			<input type="text" name="name"/>
			</td></tr> 
			
			<tr><td>Email:</td><td>
			<input type="email" name="email"/>
			</td></tr> 
			
			<tr><td>Mobile:</td><td> 
			<input type="text" name="phone"/> 
			</td></tr>
			
			<tr>
			<td><label>Gender</label></td>
			<td><input type="radio" name="gender" value="Male">Male
				<input type="radio" name="gender" value="Female">Female
			</td>
			</tr>
			
			<tr><td>Password:</td><td>
			<input type="password" name="password"/>
			</td></tr> 
			 
			 
			<tr><td colspan="2">
			<input type="submit" value="submit"/>
			</td></tr>  
			
		</table>  
		</form>  
  		<br/>  
			
			<a href="ViewServlet">view employees</a>  
</body>
</html>