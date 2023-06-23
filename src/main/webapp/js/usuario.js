// muestra que formulario se despliega para crear un usuario
$(document).ready(function() {
	$("#form-usuario").submit(function(event) {
		event.preventDefault();
	});
});


	// Obtener el elemento <select>
	let selectTipoUsuario = document.querySelector('select[name="tipoUsuario"]');

	// Agregar un evento de cambio
	selectTipoUsuario.addEventListener('change', function() {
		let tipoUsuario = selectTipoUsuario.value;
		let formularioContainer = document.getElementById('formulario-container');
		
		let url = "form-" + tipoUsuario + ".jsp";

		// Hacer una solicitud AJAX para cargar el formulario correspondiente
		$.ajax({
			type: 'GET',
			url: url, // Puedes crear un archivo JSP separado para cada tipo de formulario
			data: { tipoUsuario: tipoUsuario },
			success: function(response) {
				formularioContainer.innerHTML = response; // Insertar el formulario en el contenedor
			}
		});
	});
