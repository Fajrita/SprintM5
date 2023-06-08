<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Home</title>
</head>

<body>
	<!-- Navbar -->
	<jsp:include page="navbar.jsp" />
	<!-- End Navbar -->
	<div class="container mt-5">
		<!-- <a href="index.jsp">Volver</a> -->

		<div class="card" style="width: 18rem;">
			<img src="images/College-Student-PNG.png" class="card-img-top"
				alt="Personas sonriendo">
			<div class="card-body">

				<div class="">
					<a href="ServletCrearCapacitacion">
						<button class="btn btn-secondary">Crear capacitación</button>
					</a>
				</div>
			</div>
		</div>

	</div>
	<!-- 	script bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>

</html>