<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search By ID</title>
</head>
<body>
<h3>Add a new film to Filmbuster</h3>
<form action="AddNewFilm.do" method="POST">
Title:
<input type="text" name="title" size="4"/>
Description:
<input type="text" name="description" size="4"/>
Release Year:
<input type="text" name="releaseYear" size="4"/>
Language ID:
<input type="text" name="languageID" size="4"/>
Rental Duration:
<input type="text" name="rentalDuration" size="4"/>
Rental Rate:
<input type="text" name="rentalRate" size="4"/>
Length:
<input type="text" name="length" size="4"/>
Replacement Cost:
<input type="text" name="replacementCost" size="4"/>
Rating:
<input type="text" name="rating" size="4"/>
Special Features:
<input type="text" name="specialFeatures" size="4"/>

<input type="submit" value="Submit Film to Database"/>

</form>


</body>
</html>