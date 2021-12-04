<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Film</title>
</head>
<body>

		<label for="id">ID: ${film.id}</label> <br>
	<form action="UpdateInfo.do" method="GET">
		<label for="title">Title: </label> <input type="text" name="title" value="${film.title}"><br>
		<label for="description">Description: </label> <input type="text" name="description" value="${film.description}"><br>
		<label for="releaseYear">ReleaseYear: </label> <input type="text" name="releaseYear" value="${film.releaseYear}"><br>
		<label for="languageId">Language ID: </label> <input type="text" name="languageId" value="${film.languageId}"><br>
		<label for="rentalDuration">Rental Duration: </label> <input type="text" name="rentalDuration" value="${film.rentalDuration}"><br>
		<label for="length">Length: </label> <input type="text" name="length" value="${film.length}"><br>
		<label for="replacementCost">Replacement Cost: </label> <input type="text" name="title" value="${film.replacementCost}"><br>
		<label for="rating">Rating: </label> <input type="text" name="rating" value="${film.rating}"><br>
		<label for="specialFeatures">Special Features: </label> <input type="text" name="title" value="${film.specialFeatures}"><br>
		<input type="submit" value="Submit Changes">
	</form>

</body>
</html>