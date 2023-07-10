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
				<a class="me-3" href="/logout">Logout</a>
			</div>
		</div>
		
		<div class="mb-3">
			<p>${game.gameTitle }</p>
			<div class="card w-50">
			
				<div class="card-body">
					<p>Year Released: ${game.yearReleased }</p>
					<p>Publisher: ${ game.publisher}</p>
					<p>Summary: 
						${game.summary }
					</p>
				</div>
			</div>
			
		</div>
		
		<div class="w-50 d-flex justify-content-end">
			<a class="btn btn-outline-dark me-3" href="/games/edit/${game.id }">
				Edit
			</a>
			
			<form action="/games/delete/${game.id }" method="post">
				<input type="hidden" name="_method" value="delete" />
				<button class="btn btn-danger">Delete</button>
			</form>
		</div>
		
	</div>

</body>
</html>