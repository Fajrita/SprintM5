<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Crear Capacitación - Nombre de la Empresa</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/styles.css">

</head>

<body>
	<%@ include file="navbar.jsp"%>

	<div class="container mt-3">
		<h1 class="text-center">Crear Capacitación</h1>

		<div class="row justify-content-center mt-5">
			<div class="col-12 col-md-6">
				<div class="custom-form-container">
					<form id="form-capacitacion">
						<div class="mb-3">
							<label for="rutCliente" class="form-label">RUT del
								Cliente:</label> <input type="text" class="form-control" id="rutCliente"
								name="rutCliente">
						</div>

						<div class="mb-3">
							<label for="dia" class="form-label">Día:</label> <input
								type="date" class="form-control" id="dia" name="dia">
						</div>

						<div class="mb-3">
							<label for="hora" class="form-label">Hora:</label> <input
								type="text" class="form-control" id="hora" name="hora">
						</div>

						<div class="mb-3">
							<label for="lugar" class="form-label">Lugar:</label> <input
								type="text" class="form-control" id="lugar" name="lugar">
						</div>

						<div class="mb-3">
							<label for="duracion" class="form-label">Duración:</label> <input
								type="text" class="form-control" id="duracion" name="duracion">
						</div>

						<div class="mb-3">
							<label for="cantidadAsistentes" class="form-label">Cantidad
								de Asistentes:</label> <input type="text" class="form-control"
								id="cantidadAsistentes" name="cantidadAsistentes">
						</div>

						<button type="submit" class="btn btn-primary">Crear
							Capacitación</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<script src="js/capacitacion.js"></script>
</body>
</html>
