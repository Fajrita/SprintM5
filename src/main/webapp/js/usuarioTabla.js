$(document).ready(function() {
	$("#table-usuario").submit(function(event) {
		event.preventDefault();
		authUser()
	});
});


	// Obtener el elemento <select>
	let selectTipoUsuario = document.querySelector('select[name="tipoUsuario"]');

	// Agregar un evento de cambio
	selectTipoUsuario.addEventListener('change', function() {
		let tipoUsuario = selectTipoUsuario.value;
		let tableContainer = document.getElementById('table-container');
		
		let url = "table-" + tipoUsuario + ".jsp";

		// Hacer una solicitud AJAX para cargar el formulario correspondiente
		$.ajax({
			type: 'GET',
			url: url, // Puedes crear un archivo JSP separado para cada tipo de formulario
			data: { tipoUsuario: tipoUsuario },
			success: function(response) {
				tableContainer.innerHTML = response; // Insertar el formulario en el contenedor
			}
		});
		
	});
	
	