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
	
		<div class="mb-4 d-flex justify-content-between">
			<h1>Welcome, ${user.userName }!</h1>
			<div class="align-self-center">
				<a class="me-3" href="/games/add">Add a Game</a>
				<a class="me-3" href="/journal/add">Add an Entry</a>
				<a href="/logout">Logout</a>
			</div>
			
		</div>
		
		
		<div class="row">
		
			<div class="col-6">
				<h3>Games:</h3>
				<div class="card">
					<div class="card-body">
						<ul class="list-unstyled">
							<c:forEach var="game" items="${games }">
								<li>
									<a href="/games/${game.id }">
										${game.gameTitle }
									</a>
								</li>
							</c:forEach>
						</ul>
						
					</div>
				</div>
			</div>
		
			
			<div class="col-6">
				<h3>Your Journal Entries:</h3>
				
				<table class="table table-striped table-bordered">
					
					<thead style="background-color: lightgrey;">
						<th>Game Title</th>
						<th>Actions</th>
					</thead>
					<tbody>
						<c:forEach var="journalEntry" items="${journalEntries }">
							<tr>
								<td>
									<a href="/journal/${journalEntry.id }">
										${journalEntry.game.gameTitle }
									</a>
								</td>
								<td>
									<a href="/journal/edit/${journalEntry.id }">
										Edit
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		
		</div>
		
	
	</div>

</body>
</html>