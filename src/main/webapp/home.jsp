<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
		<div class="row justify-content-center">
			<div class="card col-xs-12 col-sm-6 col-md-4 m-2"
				style="width: 18rem;">
				<img src="images/College-Student-PNG.png" class="card-img-top mt-2"
					alt="Personas sonriendo">
				<div class="card-body">

					<div class="d-flex justify-content-center">
						<a href="capacitacion.jsp">
							<button class="btn btn-secondary">Crear capacitación</button>
						</a>
					</div>
				</div>
			</div>
			<div class="card col-xs-12 col-sm-6 col-md-4 m-2"
				style="width: 18rem;">
				<img src="images/cathryn-lavery-fMD_Cru6OTk-unsplash.jpg"
					class="card-img-top mt-2" alt="Personas sonriendo">
				<div class="card-body">

					<div class="d-flex justify-content-center">
						<a href="ServletListaCapacitaciones">
							<button class="btn btn-secondary">Listar capacitaciones</button>
						</a>
					</div>
				</div>
			</div>

			<div class="card col-xs-12 col-sm-6 col-md-4 m-2"
				style="width: 18rem;">
				<img src="images/thomas-lefebvre-gp8BLyaTaA0-unsplash.jpg"
					class="card-img-top mt-2" alt="Personas sonriendo">
				<div class="card-body">
					<div class="d-flex justify-content-center">
						<a href="crear-usuario.jsp">
							<button class="btn btn-secondary">Crear usuario</button>
						</a>
					</div>
				</div>
			</div>
			
				<div class="card col-xs-12 col-sm-6 col-md-4 m-2"
				style="width: 18rem;">
				<img src="images/emmanuel-ikwuegbu-jpteF5elwk8-unsplash.jpg"
					class="card-img-top mt-2" alt="Personas sonriendo">
				<div class="card-body">
					<div class="d-flex justify-content-center">
						<a href="lista-usuarios.jsp">
							<button class="btn btn-secondary">Listar usuarios</button>
						</a>
					</div>
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
