<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>


<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
<<<<<<< HEAD
		<a class="navbar-brand" href="contacto.jsp">SprintM5</a>
=======
		<a class="navbar-brand" href="ServletIndex">SprintM5</a>

>>>>>>> ejercicios
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="true"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
<<<<<<< HEAD
					aria-current="page" href="#">Inicio</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Contacto</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Menu </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul></li>
=======
					aria-current="page" href="ServletIndex">Inicio</a></li>
				<li class="nav-item"><a class="nav-link" href="ServletContacto">Contacto</a></li>
				<li class="nav-item"><a class="nav-link"
					href="capacitacion.jsp">Capacitacion</a></li>
>>>>>>> ejercicios
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
	