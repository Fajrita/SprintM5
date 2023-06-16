

<%@page import="cl.awakelab.ejercicio.model.entity.Usuario"%>
<%@page import="cl.awakelab.ejercicio.model.entity.Administrativo"%>
<%@page import="java.util.List"%>
<div class="container mt-5">
	<h2 class="text-center mb-4">Lista Administrativos</h2>

	<div class="table-responsive">
		<table class="table table-striped table-bordered display">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Fecha de nacimiento</th>
					<th scope="col">Run</th>
					<th scope="col">Area</th>
					<th scope="col">Experiencia Previa</th>


				</tr>
			</thead>
			<tbody class="table-group-divider">
				<!-- el ciclo for de java	 -->
				<%
				List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
				if (usuarios != null) {
					for (Usuario u : usuarios) {
				%>

				<tr>
					<td><%=u.getNombre()%></td>
					<td><%=u.getFecha()%></td>
					<td><%=u.getRun()%></td>
			

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
