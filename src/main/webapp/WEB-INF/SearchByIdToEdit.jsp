<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search By ID</title>
</head>
<body>
<h3>First, search for Film to edit by ID</h3>
<form action="SearchFilmToEdit.do" method="GET">
Enter ID Number: 
<input type="text" name="filmId" size="4"/>
<input type="submit" value="Get Film Data"/>

</form>


</body>
</html>