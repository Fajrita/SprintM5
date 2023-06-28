<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="cl.awakelab.ejercicio.model.entity.Usuario" %>
<!DOCTYPE html>
<html lang="es">
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

<%@ page import="javax.servlet.http.HttpServletRequest" %>


	<div class="container mt-5">
		<h1 class="text-center">Update Usuario</h1>
		<div class="form-floating col-12 col-md-8 offset-md-2 col-lg-6 offset-lg-3 mt-4"
			id="form-usuario">



		<div class="container mt-3">
	<h1 class="text-center">Administrativo</h1>

	<div class="row justify-content-center mt-5">
		<div class="col-12">

			<div class="custom-form-container">
				<form id="form-administrativo">
					<!-- Campos y elementos del formulario para el tipo de usuario administrativo -->
					<div>

						<label for="nombre" class="form-label">Nombre:</label> <input
							type="text" class="form-control" id="nombre" name="nombre" value="${nombre}" 
							required><br>
					</div>

					<div>
						<label for="fecha" class="form-label">Fecha de nacimiento:</label>
						<input type="date" class="form-control" id="fecha" name="fecha" value="${fecha}"
							required><br>
					</div>

					<div>
						<label for="run" class="form-label">Run:</label> <input
							type="text" class="form-control" id="run" name="run" value="${run}" required><br>
					</div>

					<div>
						<label for="area" class="form-label">Area:</label> <input
							type="text" class="form-control" id="area" name="area" value="${area}" required><br>
					</div>

					<div>
						<label for="experienciaPrevia" class="form-label">Experiencia
							previa:</label> <input type="text" class="form-control"
							id="experienciaPrevia" name="experienciaPrevia" value="${experienciaPrevia}" required><br>
					</div>

					<div class="d-grid gap-2 mt-3 mb-3">

						<button type="submit" class="btn btn-primary">Crear
							Administrativo</button>
					</div>

				</form>
			</div>
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
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/updateUsuario.js"></script> 
</body>
</html>