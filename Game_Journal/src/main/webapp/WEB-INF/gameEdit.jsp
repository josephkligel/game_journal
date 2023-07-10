<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	
		<div class="mb-4 d-flex justify-content-between">
			<h1>Game Journal</h1>
			<div class="align-self-center">
				<a class="me-3" href="javascript:history.back()">Go Back</a>
				<a class="me-3" href="/home">Home</a>
				<a href="/logout">Logout</a>
			</div>
		</div>
	
		<div class="w-75">
			<form:form action="/games/update" method="post" modelAttribute="game">
			
				
				<input type="hidden" name="_method" value="put" />
				<form:input type="hidden" value="${game.id }" path="id" />
			
				<p class="text-center">Edit a Game</p>
				
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="gameTitle">Game Title:</form:label>					
					<form:input class="col-sm-5" type="text" path="gameTitle" />
					<form:errors class="text-danger" path="gameTitle" />
				</div>
				
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="yearReleased">Year Release:</form:label>					
					<form:input class="col-sm-5" type="number" path="yearReleased" placeholder="1958" />
					<form:errors class="text-danger" path="yearReleased" />
				</div>
				
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="publisher">Publisher:</form:label>					
					<form:input class="col-sm-5" type="text" path="publisher" />
					<form:errors class="text-danger" path="publisher" />
				</div>
				
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="summary">Summary:</form:label>					
					<form:textarea class="col-sm-5" path="summary" />
					<form:errors class="text-danger" path="summary" />
				</div>
				
				<div class="text-center">
					<button class="btn btn-outline-dark">Update</button>
				</div>
			</form:form>	
		</div>
	</div>


</body>
</html>