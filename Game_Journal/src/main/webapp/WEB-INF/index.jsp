<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Journal</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container pt-3">
	
		<div class="mb-4">
			<h1>Welcome to Game Journal!</h1>
			<p>Join our growing community.</p>
		</div>
		
		<div class="row">
		
			<form:form class="col me-3" action="/register" method="post" modelAttribute="newUser">
			
				<h3>Register</h3>
			
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="userName">User Name:</form:label>					
					<form:input class="col-sm-4" type="text" path="userName" />
					<form:errors class="text-danger" path="userName"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="email">Email:</form:label>					
					<form:input class="col-sm-4" type="text" path="email" />
					<form:errors class="text-danger" path="email"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="password">Password:</form:label>
					<form:input class="col-sm-4" type="password" path="password" />
					<form:errors class="text-danger" path="password"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="confirm">Confirm PW:</form:label>
					<form:input class="col-sm-4" type="password" path="confirm"></form:input>
					<form:errors class="text-danger" path="confirm"></form:errors>
				</div>
				
				<div class="text-center mt-4">
					<input class="btn btn-primary" type="submit" value="Register" />
				</div>
			
			</form:form>
			
			<!-- Login Form ------------------- -->
			
			<form:form style="vertical-align: top" class="col" action="/login" method="post" modelAttribute="newLogin">
			
				<h3>Login</h3>
			
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="email">Email:</form:label>					
					<form:input class="col-sm-4" type="text" path="email" />
					<form:errors class="text-danger" path="email"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="password">Password:</form:label>
					<form:input class="col-sm-4" type="password" path="password" />
					<form:errors class="text-danger" path="password"></form:errors>
				</div>
				
				<div class="text-center mt-4">
					<input class="btn btn-success" type="submit" value="Login" />
				</div>
			
			</form:form>
					
		</div>
		
	</div>

</body>
</html>