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
<title>Login</title>

</head>

<body>

	<div class="container">
		<div class="row custom-center">
			<div class="card col-md-6 col-lg-4 custom-form-container">
				<div class="card-body p-4">
					<h5 class="card-title mb-4">Iniciar sesión</h5>
					<form id="form-login">
						<div class="mb-3">
							<label for="user" class="form-label">Nombre de usuario</label> <input
								type="text" class="form-control" id="user" name="usuario"
								placeholder="Ingrese su nombre de usuario" required>
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">Contraseña</label> <input
								type="password" class="form-control" id="password"
								name="password" placeholder="Ingrese su contraseña" required>
						</div>
						<div class="d-grid">
							<button type="submit" class="btn btn-primary">Iniciar
								sesión</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- script bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/app.js"></script>

</body>
</html>