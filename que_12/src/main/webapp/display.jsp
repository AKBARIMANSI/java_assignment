<%@page import="java.util.ArrayList"%>
<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	
	<script type="text/javascript">
		
		$(document).ready(function(){
			
			
			$.get('viewimg',{},function(rt){
				
				const data = JSON.parse(rt)
				
				var row = "";
				for(var i=0;i<data.length;i++)
				{
					row = row+"<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td><img src='img/"+data[i].image+"' alt='"+data[i].image+" height='50px' width='60px''></td></tr>"
				}
				$('#tdata').html(row)
			})
		})
		
	</script>
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

          <div class="container">
          <div class = "row">
          <div class = "col-md-6 m-auto">
          <h1 align = "center">Employee Details</h1>
                 
                  <table class = "table">
                  <tr>
                  <th>Id</th>
                  <th>Uname</th>
                  <th>Email</th>
                  <th>Password</th>
                  <th>Phone</th>
                  <th>Action</th>
                  <th><a href="logout"></a>logout</th>
                  </tr>
                  
               <%
                    ArrayList<Employee> emp =(ArrayList<Employee>)request.getAttribute("data");
                    
                    for(Employee e:emp)
                    { %>
                       <tr>
                    	<td><%=e.getId()%></td>
                    	 <td><%=e.getUname()%></td>
                    	  <td><%=e.getEmail()%></td>
                    	   <td><%=e.getPass()%></td>
                    	    <td><%=e.getPhone()%></td>
                    	     <td><a href="update?action=edit&uid=<%=e.getId()%>"class ="btn btn-primary">Edit</a></td>
                    	     <td><a href="update?action=delete&uid=<%=e.getId()%>"class ="btn btn-danger">Delete</a></td>
                   
                        </tr>
                    <% }
               
                 %>   
                 
          </table>
          
          <br><br>
		
		<table>
			<tr>
				<th>Image</th>
			</tr>
			
			<tbody id="tdata">
				
			</tbody>
		</table>
		
          </div>
          </div>
          </div>
          
</body>
</html>