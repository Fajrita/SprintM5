
<%@ page import="cl.awakelab.ejercicio.model.entity.Usuario" %>
<%@ page import="cl.awakelab.ejercicio.model.entity.Administrativo" %>
<div class="container mt-3">
	<h1 class="text-center">Formulario Administrativo</h1>

	<div class="row justify-content-center mt-5">
		<div class="col-12 col-md-8 col-lg-6">

			<div class="custom-form-container">
				<form id="form-administrativo">
					<!-- Campos y elementos del formulario para el tipo de usuario administrativo -->
					<div>

						<label for="nombre" class="form-label">Nombre:</label> <input
							type="text" class="form-control" id="nombre" name="nombre" value="${nombre}" 
							required><br>
					</div>

					<div>
						<label for="fecha" class="form-label">Fecha de nacimiento:</label>
						<input type="date" class="form-control" id="fecha" name="fecha" 
							required><br>
					</div>

					<div>
						<label for="run" class="form-label">Run:</label> <input
							type="text" class="form-control" id="run" name="run" value="${run}" required><br>
					</div>

					<div>
						<label for="area" class="form-label">Area:</label> <input
							type="text" class="form-control" id="area" name="area" required><br>
					</div>

					<div>
						<label for="experienciaPrevia" class="form-label">Experiencia
							previa:</label> <input type="text" class="form-control"
							id="experienciaPrevia" name="experienciaPrevia" required><br>
					</div>

					<div class="d-grid gap-2 mt-3 mb-3">

						<button type="submit" class="btn btn-primary">Crear
							Administrativo</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>


