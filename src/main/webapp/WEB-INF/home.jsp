<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Spring MVC Film Site</title>
<nav>
	<c:choose>
		<h1>Welcome to Filmbuster!</h1>

		<a href="SearchByID.do">Search film by ID</a>
	</c:choose>
</nav>