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
	<link rel="stylesheet" href="css/styles.css">
<title>Home</title>
</head>

<body>
	<!-- Navbar -->
	<jsp:include page="navbar.jsp" />
	<!-- End Navbar -->
	<div class="container d-flex mt-5">
		<!-- <a href="index.jsp">Volver</a> -->

		<div class="card m-3" style="width: 18rem;">
			<img src="images/College-Student-PNG.png" class="card-img-top"
				alt="Personas sonriendo">
			<div class="card-body">

				<div class="">
					<a href="capacitacion.jsp">
						<button class="btn btn-secondary">Crear capacitación</button>
					</a>
				</div>
			</div>
		</div>
		
		<div class="card m-3" style="width: 18rem;">
			<img src="images/cathryn-lavery-fMD_Cru6OTk-unsplash.jpg" class="card-img-top"
				alt="Personas sonriendo">
			<div class="card-body">

				<div class="">
					<a href="ServletListaCapacitaciones">
						<button class="btn btn-secondary">Listar capacitaciones</button>
					</a>
				</div>
			</div>
		</div>

	</div>

</body>

</html>