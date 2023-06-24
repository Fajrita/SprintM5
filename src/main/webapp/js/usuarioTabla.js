$(document).ready(function() {
	$("#table-usuario").submit(function(event) {
		event.preventDefault();
		authUser()
	});
});

let selectTipoUsuario = document.querySelector('select[name="tipoUsuario"]');

selectTipoUsuario.addEventListener('change', function() {
	let tipoUsuario = selectTipoUsuario.value;
	let tableContainer = document.getElementById('table-container');

	let url = "table-" + tipoUsuario + ".jsp";


	$.ajax({
		type: 'GET',
		url: url,
		data: { tipoUsuario: tipoUsuario },
		success: function(response) {
			tableContainer.innerHTML = response;
		}
	});

});

