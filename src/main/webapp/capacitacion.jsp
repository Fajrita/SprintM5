<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<link rel="stylesheet" href="css/styles.css">
</head>

<body>

	<jsp:include page="navbar.jsp" />


	<div class="container">
		<h1 class="text-center">Crear Capacitación</h1>

		<!-- 	Codigo del Formulario Capacitacion -->
		<div class="row mt-5">
			<div class="col-6 offset-3">

				<form id="form-capacitacion">
					<div>
						<label for="rutCliente" class="form-label">RUT del
							Cliente:</label> <input type="text" class="form-control" id="rutCliente"
							name="rutCliente" required><br>

					</div>

					<div>
						<label for="dia" class="form-label">Día:</label> <input
							type="text" class="form-control" id="dia" name="dia" required><br>
					</div>

					<div>
						<label for="hora" class="form-label">Hora:</label> <input
							type="text" class="form-control" id="hora" name="hora" required><br>
					</div>

					<div>
						<label for="lugar" class="form-label">Lugar:</label> <input
							type="text" class="form-control" id="lugar" name="lugar" required><br>
					</div>

					<div>
						<label for="duracion" class="form-label">Duración:</label> <input
							type="text" class="form-control" id="duracion" name="duracion"
							required><br>
					</div>

					<div>
						<label for="cantidadAsistentes" class="form-label">Cantidad
							de Asistentes:</label> <input type="text" class="form-control"
							id="cantidadAsistentes" name="cantidadAsistentes" required><br>
					</div>

					<div class="d-grid gap-2">

						<button type="submit" class="btn btn-primary">Crear
							Capacitación</button>

					</div>

				</form>

			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/capacitacion.js"></script>
</body>
</html>
