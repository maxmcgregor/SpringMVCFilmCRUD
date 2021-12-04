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
        <li>Title: ${film.title}</li>
        <li>${film.description}</li>
        <li>Released: ${film.releaseYear}</li>
        <li>Length: ${film.length}</li>
        <li>Rating: ${film.rating}</li>
        <li>Special Features: ${film.specialFeatures}</li>
      </ul>
    </c:when>
    <c:otherwise>
      <p>No film found :(</p>
    </c:otherwise>
  </c:choose>


</body>
</html>