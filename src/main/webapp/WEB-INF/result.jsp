<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film info</title>
</head>
<body>

	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<li>Film ID: ${film.id}</li>
				<li>Title: ${film.title}</li>
				<li>${film.description}</li>
				<li>Released: ${film.releaseYear}</li>
				<li>Language ID: ${film.languageId}</li>
				<li>Rental Duration: ${film.rentalDuration}</li>
				<li>Length: ${film.length}</li>
				<li>Replacement Cost: ${film.replacementCost}</li>
				<li>Rating: ${film.rating}</li>
				<li>Special Features: ${film.specialFeatures}</li>
			</ul>

			<a href="home.do">Return Home</a>
			<br><br>
			
			<form action="delete.do" method="GET">
				<label for="filmId">Film ID: </label><input type="text" name="filmId" value="${film.id}">
				<input type="submit" value="Delete this film">
			</form>
		</c:when>
		<c:otherwise>
			<p>Oh no! That didn't work :(</p>
			<a href="home.do">Return Home</a>
		</c:otherwise>
	</c:choose>


</body>
</html>