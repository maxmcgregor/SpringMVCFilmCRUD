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
<form action="AddNewFilmFormInfo.do" method="POST">
Title:
<input type="text" name="title" size="4"/>
<br>Description:
<input type="text" name="description" size="4"/>
<br>Release Year:
<input type="text" name="releaseYear" size="4"/>
<br>Language ID:
<input type="text" name="languageID" size="4"/>
<br>Rental Duration:
<input type="text" name="rentalDuration" size="4"/>
<br>Rental Rate:
<input type="text" name="rentalRate" size="4"/>
<br>Length:
<input type="text" name="length" size="4"/>
<br>Replacement Cost:
<input type="text" name="replacementCost" size="4"/>
<br>Rating:
<input type="text" name="rating" size="4"/>
<br>Special Features:
<input type="text" name="specialFeatures" size="4"/>
<br>
<input type="submit" value="Submit Film to Database"/>

</form>


</body>
</html>