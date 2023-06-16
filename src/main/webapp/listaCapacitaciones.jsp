<%@page import="cl.awakelab.ejercicio.model.entity.Capacitacion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listado de Capacitaciones</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/styles.css">
</head>

<body>
	<!-- Navbar -->
	<jsp:include page="navbar.jsp" />
	<!-- End Navbar -->
	<div class="container mt-5">
		<h2 class="text-center mb-4">Lista Capacitaciones</h2>
		
		<div class="table-responsive">
		<table class="table table-striped table-bordered display">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">Rut Cliente</th>
							<th scope="col">Día</th>
							<th scope="col">Hora</th>
							<th scope="col">Lugar</th>
							<th scope="col">Duración</th>
							<th scope="col">Cantidad de Asistentes</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<!-- el ciclo for de java -->
						<%List<Capacitacion> capacitaciones = (List<Capacitacion>)request.getAttribute("capacitaciones");
						if (capacitaciones != null) {
							for (Capacitacion c : capacitaciones) {
						%>
						<tr>
							<td><%=c.getId()%></td>
							<td><%=c.getRutCliente()%></td>
							<td><%=c.getDia()%></td>
							<td><%=c.getHora()%></td>
							<td><%=c.getLugar()%></td>
							<td><%=c.getDuracion()%></td>
							<td><%=c.getCantidadAsistentes()%></td>
							
						</tr>
						<!-- fin del for de java -->

						<%
						}	
						}
						%>
					</tbody>
				</table>
		
		</div>
				
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
		integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
		crossorigin="anonymous"></script>
		 <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
	  <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
</body>

</html>