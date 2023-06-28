<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<%
  String type = request.getParameter("type");
  String run = request.getParameter("value");
  
  // Aquí puedes utilizar los valores de type y value como desees
%>
	<div class="container mt-5">
		<h1 class="text-center">Crear Usuario</h1>
		<div class="form-floating col-10 offset-1 col-md-6 offset-md-3 mt-4"
			id="form-usuario">
			<select name="tipoUsuario" class="form-select" id="floatingSelect"
				aria-label="Floating label select example">
				<option selected>Seleccione tipo de usuario</option>
				<option value="administrativo">Administrativo</option>
				<option value="cliente">Cliente</option>
				<option value="profesional">Profesional</option>
			</select> <label for="floatingSelect">Tipo de usuario</label>
		</div>

		<div id="formulario-container"></div>

	</div>



	<!-- 	script bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/formUsuarioByType.js"></script>
	<script src="js/createUsuario.js"></script>
</body>
</html>
