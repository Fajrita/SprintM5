

		<div class="row mt-5">
			<div class="col-6 offset-3">

        <h1> Form Cliente </h1>
				
          <form id="form-cliente" action="crear-usuario-servlet" method="POST">

          <div>
						<label for="nombre" class="form-label">Nombre:</label> <input
							type="text" class="form-control" id="nombre" name="nombre" required><br>
					</div>
					<div>
						<label for="fecha" class="form-label">Fecha:</label> <input type="date" class="form-control" id="fecha"
							name="rutCliente" required><br>

					</div>

					<div>
						<label for="dia" class="form-label">D�a:</label> <input
							type="text" class="form-control" id="dia" name="dia" required><br>
					</div>

					<div>
						<label for="hora" class="form-label">Hora:</label> <input
							type="text" class="form-control" id="hora" name="hora" required><br>
					</div>

					<div>
						<label for="lugar" class="form-label">Lugar:</label> <input
							type="text" class="form-control" id="lugar" name="lugar" required><br>
					</div>

					<div>
						<label for="duracion" class="form-label">Duraci�n:</label> <input
							type="text" class="form-control" id="duracion" name="duracion"
							required><br>
					</div>

					<div>
						<label for="cantidadAsistentes" class="form-label">Cantidad
							de Asistentes:</label> <input type="text" class="form-control"
							id="cantidadAsistentes" name="cantidadAsistentes" required><br>
					</div>

					<div class="d-grid gap-2">

						<button type="submit" class="btn btn-primary">Crear
							Capacitaci�n</button>

					</div>

				</form>
			</div>
		</div>
