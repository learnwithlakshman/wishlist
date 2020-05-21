<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Wish List</title>
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">WishList App</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link active" href="/wl/home">Home <span
					class="sr-only">(current)</span></a> <a class="nav-item nav-link"
					href="#">Profile</a> <a class="nav-item nav-link" href="#">Account</a>
			</div>
			<div class="navbar-nav ml-auto">
				<a class="nav-item nav-link" href="/logout">Logout</a>
			</div>
		</div>
	</nav>


	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">

				<form:form method="post" modelAttribute="updatewishlist" action="/wl/updatewl">
					<div class="form-group">
						<label for="wlname">WishList Name</label>
						<form:input path="name" type="text" class="form-control"
							id="wlname" name="wlname" />
					</div>
					<div class="form-group">
						<label for="wldesc">Description</label>
						<form:input path="description" type="text" class="form-control"
							id="wldesc" name="wldesc" />
					</div>

					<button type="submit" class="btn btn-primary">Update</button>
				</form:form>

			</div>
			<div class="col-md-3"></div>
		</div>
	</div>


</body>
</html>