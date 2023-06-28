// permite crear un usuario por tipo via post al ServletCrearUsuario
$(document).ready(function() {
	$('#formulario-container').submit(function(event) {
		event.preventDefault();
		let typeValue = $('select[name="tipoUsuario"]').val();

		let data = {
			tipoUsuario: typeValue,
			nombre: $('#nombre').val(),
			fecha: $('#fecha').val(),
			run: $('#run').val()
		};

		switch (typeValue) {
			case "administrativo":
				data.area = $('#area').val();
				data.experienciaPrevia = $('#experienciaPrevia').val();
				break;

			case "cliente":
				data.telefono = $('#telefono').val();
				data.afp = $('#afp').val();
				data.sistemaSalud = $('#sistemaSalud').val();
				data.direccion = $('#direccion').val();
				data.comuna = $('#comuna').val();
				break;

			case "profesional":
				data.titulo = $('#titulo').val();
				data.fechaIngreso = $('#fechaIngreso').val();
				break;

			default:
				break;
		}

		$.ajax({
			type: 'POST',
			url: './ServletCrearUsuario',
			contentType: 'application/json',
			data: JSON.stringify(data),
			success: function(response) {
				console.log(data)
				console.log("Usuario creado exitosamente: " + response);
				 $('#nombre').val('');
                $('#fecha').val('');
                $('#run').val('');

                $('#area').val('');
                $('#experienciaPrevia').val('');

                $('#telefono').val('');
                $('#afp').val('');
                $('#sistemaSalud').val('');
                $('#direccion').val('');
                $('#comuna').val('');

                $('#titulo').val('');
                $('#fechaIngreso').val('');
                document.location.href = "lista-usuarios.jsp";

			},
			error: function(error) {
				console.log("Error al crear el usuario: " + error);

			}
		});
	});
});
