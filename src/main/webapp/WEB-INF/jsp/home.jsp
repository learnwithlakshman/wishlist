<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/main.css">
</head>
<body>

	<img src="/images/1.jfif" alt="IPL Image">
	 <h3>Hello ${user}, Welcome to Spring Boot JSP world</h3>
	
	<h3>Here are the your friends:</h3>
	<ul>
	<c:forEach items="${names}" var="name">
		<li>${name}</li>	
	</c:forEach>
	
	</ul>
	
	<button id="imageId">Click</button>
	<script type="text/javascript" src="/js/main.js"></script>
</body>
</html>