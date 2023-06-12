<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/styles.css">
</head>

<body>

	<jsp:include page="navbar.jsp" />


	<div class="container mt-5">
		<h1 class="text-center">Crear Cliente</h1>

		<!-- 	Codigo del Formulario Capacitacion -->
		<div class="row mt-5" id="form-usuario">
			<div class="col-10 offset-1 col-md-6 offset-md-3">

				<label>Tipo de usuario:</label> <select name="tipoUsuario">

					<option selected>Seleccione tipo de usuario</option>
					<option value="administrativo">Administrativo</option>
					<option value="cliente">Cliente</option>
					<option value="profesional">Profesional</option>
				</select>

				<div id="formulario-container"></div>

				<div class="d-grid gap-2">

					<button type="submit" class="mt-4 btn btn-primary">Crear
						Capacitación</button>

				</div>

			</div>
		</div>
	</div>

<!-- 	script bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/usuario.js"></script>
</body>
</html>
