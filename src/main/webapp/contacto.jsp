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
<title>Contacto</title>
</head>

<body>
	<jsp:include page="navbar.jsp" />
	
	<div class="container">
	<div class="row">

		<h2 class="h1-responsive font-weight-bold text-center my-4">
			Contáctanos</h2>

		<p class="text-center w-responsive mx-auto mb-5">¿Tienes alguna
			pregunta? No dudes en contactarnos directamente. Nuestro equipo te
			responderá en cuestión de horas.</p>

		<div class="col-md-8 offset-md-2 mb-md-0 mb-5 justify-content-center">
			<form id="contact-form" name="contact-form">
				<div class="row">
					<div class="col-md-6">
						<div class="md-form mb-0">
							<small id="nameHelp" class="form-text text-danger"></small> <input
								type="text" id="name" name="name" class="form-control"
								placeholder="Nombre Apellido" /> <label style="color: red">*</label>
							<label for="name" class="">Tu nombre</label>
						</div>
					</div>

					<div class="col-md-6">
						<div class="md-form mb-0">
							<small id="emailHelp" class="form-text text-danger"></small> <input
								type="text" id="email" name="email" class="form-control"
								placeholder="tu@correo.com" /> <label style="color: red">*</label>
							<label for="email" class="">Tu correo</label>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="md-form mb-0">
							<small id="subjectHelp" class="form-text text-danger"></small> <input
								type="text" id="subject" name="subject" class="form-control"
								placeholder="Breve descripción" maxlength="100" /> <label
								style="color: red">*</label> <label for="subject" class="">Asunto</label>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="md-form">
							<small id="messageHelp" class="form-text text-danger"></small>
							<textarea id="message" name="message" rows="4"
								class="form-control md-textarea" maxlength="500"
								placeholder="Escribe tu mensaje aquí..."></textarea>
							<label style="color: red">*</label> <label for="message">Tu
								mensaje</label>
						</div>
					</div>
				</div>
				<div class="text-center text-md-left">
					<button type="submit" class="btn btn-primary">Enviar</button>
				</div>
				<div class="status"></div>
			</form>
		</div>
	</div>
	</div>
	


	<script src="js/contacto.js"></script>

	<!-- 	<div class="container mt-5">
		<h1>Contacto</h1>
		<div class="row">
			<div class="col-4">

				<form id="form-contact">
					<div class="mb-3">
						<label for="name" class="form-label">Nombre</label> <input
							type="text" class="form-control" id="name" name="name" required />
					</div>

					<div class="mb-3">
						<label for="email" class="form-label">Correo</label> <input
							type="text" class="form-control" id="email" name="email" required />

					</div>
					<div class="mb-3">
						<label for="phone" class="form-label">Teléfono</label> <input
							type="tel" class="form-control" id="phone" name="phone" required />

					</div>
					<div class="mb-3">
						<label for="message" class="form-label">Mensaje</label>
						<textarea rows="" cols="5" class="form-control"
							id="message" name="message" required></textarea>

					</div>

					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-success">Enviar</button>
					</div>

				</form>

			</div>
		</div>

	</div> -->


<!-- 	script bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>