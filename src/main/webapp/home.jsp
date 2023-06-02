<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Home</title>
</head>

<body>
	<!-- Navbar -->
	<jsp:include page="navbar.jsp" />
	<!-- End Navbar -->
	<div class="container mt-5">
		<!-- <a href="index.jsp">Volver</a> -->

		<div class="row">
			<div class="col-4">
				<form action="ServletStudents" method="post">
					<div class="card" style="width: 18rem;">
						<img
							src="https://www.pngall.com/wp-content/uploads/8/College-Student-PNG.png"
							class="card-img-top" alt="...">
						<div class="card-body">
							<!-- <h5 class="card-title">Card title</h5>  -->
							<p class="card-text"></p>

						</div>
						<div class="d-grid gap-2">
							<button type="submit" class="btn btn-secondary">Crear capacitación</button>

						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>

</html>