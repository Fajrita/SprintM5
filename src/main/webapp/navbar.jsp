<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="ServletIndex">SprintM5</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="true"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="ServletIndex">Inicio</a></li>
				<li class="nav-item"><a class="nav-link" href="ServletContacto">Contacto</a></li>
				<li class="nav-item"><a class="nav-link"
					href="capacitacion.jsp">Capacitacion</a></li>
			</ul>
			<c:if test="${not empty sessionScope.usuario}">
				<p class="mx-3 mt-3">
					Bienvenido(a) <span class="fw-bold text-capitalize">
						${sessionScope.usuario}</span>
				</p>
				<form class="form-inline" action="ServletLogout" method="post">
					<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Cerrar
						sesión</button>
				</form>
			</c:if>

		</div>
	</div>
</nav>
	<!-- 	script bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>