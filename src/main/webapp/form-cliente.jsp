

<div class="row mt-5">
	<div class="col-10 offset-1 col-md-8 offset-md-2">

		<h1>Formulario Cliente</h1>

		<form id="form-cliente" action="crear-usuario-servlet" method="POST">

			<div>
				<label for="nombre" class="form-label">Nombre:</label> <input
					type="text" class="form-control" id="nombre" name="nombre" required><br>

			</div>

			<div>
				<label for="fecha" class="form-label">Fecha de creacion:</label> <input
					type="text" class="form-control" id="fecha" name="fecha" required><br>
			</div>

			<div>
				<label for="run" class="form-label">Run:</label> <input type="text"
					class="form-control" id="run" name="run" required><br>
			</div>

			<div>
				<label for="telefono" class="form-label">Telefono:</label> <input
					type="text" class="form-control" id="telefono" name="telefono"
					required><br>
			</div>

			<div>
				<label for="afp" class="form-label">AFP:</label> <input type="text"
					class="form-control" id="afp" name="afp" required><br>
			</div>

			<div>
				<label for="sistemaSalud" class="form-label">Sistema de
					salud (1: Fonasa, 2: Isapre):</label> <input type="text"
					class="form-control" id="sistemaSalud" name="sistemaSalud" required><br>
			</div>
			
			<div>
				<label for="direccion" class="form-label">Direccion:</label> <input type="text"
					class="form-control" id="direccion" name="direccion" required><br>
			</div>
			
			<div>
				<label for="comuna" class="form-label">Comuna:</label> <input type="text"
					class="form-control" id="comuna" name="comuna" required><br>
			</div>

			<div class="d-grid gap-2 mt-3 mb-3">

				<button type="submit" class="btn btn-primary">Crear Cliente</button>

			</div>

		</form>
	</div>
</div>
