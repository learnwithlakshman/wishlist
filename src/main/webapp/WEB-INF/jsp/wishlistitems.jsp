<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WishList</title>
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
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
				<a class="nav-item nav-link" href="#">Logout</a>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<button type="button" class="btn btn-primary mt-2"
					data-toggle="modal" data-target="#exampleModal">Add New
					Item</button>
			</div>
			<div class="col-md-5 mt-2">
				<h4>Wishlist Name: ${wlname}</h4>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Descripition</th>
							<th scope="col">Link</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${items}" var="item">
							<tr>
								<th>${item.name}</th>
								<th>${item.description}</th>
								<th>${item.link}</th>
								<th>${item.status}</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-3">

				<div class="modal fade" id="exampleModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Add New Item</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form:form method="post" modelAttribute="wlitem"
									action="/wl/additem">
									<div class="form-group">
										<label for="wlname">Name</label>
										<form:input path="name" type="text" class="form-control"
											id="wlname" name="wlname" />
									</div>
									<div class="form-group">
										<label for="wldesc">Description</label>
										<form:input path="description" type="text"
											class="form-control" id="wldesc" name="wldesc" />
									</div>

									<div class="form-group">
										<label for="wllink">Link</label>
										<form:input path="link" type="text" class="form-control"
											id="wllink" name="wldesc" />
									</div>
									<div class="form-group">
										<label for="wllink">Status </label>
										<form:select path="status">

											<form:option value="PENDING" label="Pending" />
											<form:option value="COMPLETED" label="Completed" />
											<form:option value="DELETED" label="Deleted" />

										</form:select>
									</div>

									<button type="submit" class="btn btn-primary">Add Item</button>
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
								</form:form>


							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

</body>
</html>