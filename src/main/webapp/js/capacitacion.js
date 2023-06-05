$(document).ready(function() {
	$("#form-capacitacion").submit(function(event) {
		event.preventDefault();
		createCapacitacion();
	});
});

function createCapacitacion() {
	let rutCliente = $("#rutCliente").val();
	let dia = $("#dia").val();
	let hora = $("#hora").val();
	let lugar = $("#lugar").val();
	let duracion = $("#duracion").val();
	let cantidadAsistentes = $("#cantidadAsistentes").val();

	//req por body
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "./capacitacion/ServletCrearCapacitacion",
		data: JSON.stringify({
			rutCliente,
			dia,
			hora,
			lugar,
			duracion,
			cantidadAsistentes
		}),
		success: function(result) {
			let parsedResult = JSON.parse(result);
			console.log(parsedResult)
			//* retornar un false
			if (parsedResult != false) {
			
				document.location.href = "home.jsp";
			}
		}
	});
}