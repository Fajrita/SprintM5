
<!-- 	Codigo del Formulario Capacitacion -->
<div class="row mt-5">
	<div class="col-6 offset-3">
		<h1>Form administrativo</h1>

		<form id="form-administrativo" action="crear-usuario-servlet"
			method="POST">
			<!-- Campos y elementos del formulario para el tipo de usuario administrativo -->
			<div>
				<label for="nombre" class="form-label">Nombre:</label> <input
					type="text" class="form-control" id="nombre" name="nombre" required><br>

			</div>

			<div>
				<label for="fecha" class="form-label">Fecha de
					nacimiento/creacion:</label> <input type="text" class="form-control"
					id="fecha" name="fecha" required><br>
			</div>

			<div>
				<label for="run" class="form-label">Run:</label> <input type="text"
					class="form-control" id="run" name="run" required><br>
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

			<div class="d-grid gap-2">

				<button type="submit" class="btn btn-primary">Crear
					Administrativo</button>
			</div>

		</form>
	</div>
</div>
