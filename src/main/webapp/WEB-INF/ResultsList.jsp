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
		<c:when test="${! empty filmList}">
			<c:forEach var="films" items="${filmList }">
				<ul>
					<li>Film ID: ${films.id}</li>
					<li>Title: ${films.title}</li>
					<li>${films.description}</li>
					<li>Released: ${films.releaseYear}</li>
					<li>Language ID: ${films.languageId}</li>
					<li>Rental Duration: ${films.rentalDuration}</li>
					<li>Length: ${films.length}</li>
					<li>Replacement Cost: ${films.replacementCost}</li>
					<li>Rating: ${films.rating}</li>
					<li>Special Features: ${films.specialFeatures}</li>
					<li>Categories: ${films.categories}</li>
					<li>Actors:</li>
					<ol>
						<c:forEach var="actor" items="${films.actors }">
							<li>${actor.firstName} ${actor.lastName }</li>
						</c:forEach>
					</ol>
				</ul>
			</c:forEach>

			<a href="home.do">Return Home</a>
			<br>
			<br>
			
			<form action="delete.do" method="GET">
				<label for="filmId">Film ID: </label><input type="text"
					name="filmId" value="${film.id}"> <input type="submit"
					value="Delete this film">
			</form>
			<form action="SearchFilmToEdit.do" method="GET">
				<label for="filmId">Film ID: </label><input type="text"
					name="filmId" value="${film.id}"> <input type="submit"
					value="Edit this film">


			</form>
		</c:when>
		<c:otherwise>
			<p>Oh no! That didn't work :(</p>
			<a href="home.do">Return Home</a>
		</c:otherwise>
	</c:choose>


</body>
</html>