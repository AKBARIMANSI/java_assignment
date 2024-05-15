<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-5 m-auto">

				<form action="reg" method="post">
					<h1 align="center">Registration Form</h1>

					<span class="text-success">${msg}</span> <span class="text-danger">${err}</span>
					<div class="from-group">
						<input type="hidden" value="${edata.getId()}" name="id">
						<lable>uname</lable>
						<input type="text" name="uname" placeholder="enter name"
							class="form-control">
					</div>

					<div class="from-group">
						<label>email</label> <input type="text" name="email"
							placeholder="enter email" class="form-control">
					</div>

					<div class="from-group">
						<label>pass</label> <input type="password" name="pass"
							placeholder="enter password" class="form-control">
					</div>

					<div class="from-group">
						<label>phone</label> <input type="text" name="phone"
							placeholder="enter number" class="form-control">
					</div>

					<div class="from-group">
						<br> <input type="Submit" class="btn btn-success"> <span><a
							href="login.jsp">Already registered? Login here</a></span>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>