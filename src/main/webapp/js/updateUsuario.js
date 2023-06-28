// pasa los datos del usuario modificados al ServletUpdateUsuario 
$(document).ready(function() {

	// Obtener los parámetros de la URL
	const parametrosURL = new URLSearchParams(window.location.search);

	// Obtener el valor de 'type' y 'value'
	let type = parametrosURL.get('type');
	let id = parametrosURL.get('id');



		
			$('#form-usuario').submit(function(event) {
		event.preventDefault();
		
				let data = {
			tipoUsuario: type,
			nombre: $('#nombre').val(),
			fecha: $('#fecha').val(),
			run: $('#run').val()
		};

		switch (type) {
			case "administrativo":
				data.area = $('#area').val();
				data.experienciaPrevia = $('#experienciaPrevia').val();
				data.id = id;
				break;

			case "cliente":
				data.telefono = $('#telefono').val();
				data.afp = $('#afp').val();
				data.sistemaSalud = $('#sistemaSalud').val();
				data.direccion = $('#direccion').val();
				data.comuna = $('#comuna').val();
				data.id = id;
				break;

			case "profesional":
				data.titulo = $('#titulo').val();
				data.fechaIngreso = $('#fechaIngreso').val();
				data.id = id;
				break;

			default:
				break;
		}

		$.ajax({
			type: 'POST',
			url: './ServletUpdateUsuario',
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
				console.log("Error al modificar el usuario: " + error);

			}
			
		});
		});
	});


