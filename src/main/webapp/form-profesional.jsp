<!-- 	Codigo del Formulario Capacitacion -->
<div class="row mt-5">
	<div class="col-10 offset-1 col-md-8 offset-md-2">
		<h1>Formulario Profesional</h1>

		<form id="form-profesional" action="crear-usuario-servlet"
			method="POST">
			<!-- Campos y elementos del formulario para el tipo de usuario profesional -->
			<div>
				<label for="nombre" class="form-label">Nombre:</label> <input
					type="text" class="form-control" id="nombre" name="nombre" required><br>

			</div>

			<div>
				<label for="fecha" class="form-label">Fecha de nacimiento:</label> <input
					type="text" class="form-control" id="fecha" name="fecha" required><br>
			</div>

			<div>
				<label for="run" class="form-label">Run:</label> <input type="text"
					class="form-control" id="run" name="run" required><br>
			</div>

			<div>
				<label for="titulo" class="form-label">Titulo:</label> <input
					type="text" class="form-control" id="titulo" name="titulo" required><br>
			</div>

			<div>
				<label for="fechaIngreso" class="form-label">Fecha Ingreso:</label>
				<input type="text" class="form-control" id="fechaIngreso"
					name="fechaIngreso" required><br>
			</div>

			<div class="d-grid gap-2 mt-3 mb-3">

				<button type="submit" class="btn btn-primary">Crear
					Profesional</button>
			</div>

		</form>
	</div>
</div>

