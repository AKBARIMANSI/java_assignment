<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Employee Data</h1>
    <table border="1">
    
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
          
        </tr>
        
       <sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/demo" user="root" password=" "/>
					        
        <sql:query dataSource="${dataSource}" var="result">
            select * from data
        </sql:query>
        
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.id}" /></td>
                <td><c:out value="${row.name}" /></td>
                <td><c:out value="${row.age}" /></td>
            </tr>
        </c:forEach>
        
    </table>
    
</body>
</html>