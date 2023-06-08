<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container-fluid mt-3">
		<h1 class="text-center">Inicie Sesión</h1>

		<!-- 	Codigo del Formulario Login -->
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4 col-sm-6 offset-sm-3 col-8 offset-2">

				<form id="form-login">
					<div class="mb-3">
						<label for="user" class="form-label">Usuario</label> <input
							type="text" class="form-control" id="user" name="usuario"
							required />
					</div>

					<div class="mb-3">
						<label for="password" class="form-label">Contraseña</label> <input
							type="password" class="form-control" id="password"
							name="password" required />

					</div>

					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-primary">Acceder</button>
					</div>

				</form>

			</div>
		</div>
		<!-- Fin Codigo del Formulario Login -->
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/app.js"></script>




</body>
</html>