$(document).ready(function() {
	const form = $('#form-capacitacion');
	const rutCliente = $("#rutCliente");
	const dia = $("#dia");
	const hora = $("#hora");
	const lugar = $("#lugar");
	const duracion = $("#duracion");
	const cantidadAsistentes = $("#cantidadAsistentes");

	function validateForm() {
		const rutClienteValue = rutCliente.val();
		const diaValue = dia.val();
		const horaValue = hora.val();
		const lugarValue = lugar.val();
		const duracionValue = duracion.val();
		const cantidadAsistentesValue = cantidadAsistentes.val();

		const errors = {};

		const setValid = (element) => {
			element.removeClass('is-invalid');
			element.addClass('is-valid');
		};

		const setInvalid = (element) => {
			element.removeClass('is-valid');
			element.addClass('is-invalid');
		};

		/**
		 * input rutCliente validation
		 */
		if (rutClienteValue.length == 0) {
			errors['rutCliente'] = 'Este campo es obligatorio';
			setInvalid(rutCliente);
		}

		/**
		 * input dia validation
		 */
		if (diaValue.length == 0) {
			errors['dia'] = 'Este campo es obligatorio';
			setInvalid(dia);
		} else {
			setValid(dia);
		}

		/**
		 * input hora validation
		 */
		if (horaValue.length == 0) {
			errors['hora'] = 'Este campo es obligatorio';
			setInvalid(hora);
		} else {
			setValid(hora);
		}

		/**
		 * input lugar validation
		 */
		if (lugarValue.length == 0) {
			errors['lugar'] = 'Este campo es obligatorio';
			setInvalid(lugar);
		} else {
			setValid(lugar);
		}

		/**
		 * input duracion validation
		 */
		if (duracionValue.length == 0) {
			errors['duracion'] = 'Este campo es obligatorio';
			setInvalid(duracion);
		} else {
			setValid(duracion);
		}

		/**
		 * input cantidad asistentes validation
		 */
		if (cantidadAsistentesValue.length == 0) {
			errors['cantidadAsistentes'] = 'Este campo es obligatorio';
			setInvalid(cantidadAsistentes);
		} else {
			setValid(cantidadAsistentes);
		}

		$.each(errors, function(fieldName, errorMsg) {
			const helpElem = $(`#${fieldName}Help`);
			if (errorMsg) {
				helpElem.text(errorMsg);
				setInvalid(helpElem.parent().find(`#${fieldName}`));
			} else {
				helpElem.text('');
			}
		});

		return Object.values(errors).every((errorMsg) => !errorMsg);
	}

	rutCliente.on('input', () => {
		const helpElem = $('#rutClienteHelp');
		helpElem.text('');
		rutCliente.removeClass('is-invalid');
	});

	dia.on('input', () => {
		const helpElem = $('#diaHelp');
		helpElem.text('');
		dia.removeClass('is-invalid');
	});

	hora.on('input', () => {
		const helpElem = $('#horaHelp');
		helpElem.text('');
		hora.removeClass('is-invalid');
	});

	lugar.on('input', () => {
		const helpElem = $('#lugarHelp');
		helpElem.text('');
		lugar.removeClass('is-invalid');
	});

	duracion.on('input', () => {
		const helpElem = $('#duracionHelp');
		helpElem.text('');
		duracion.removeClass('is-invalid');
	});

	cantidadAsistentes.on('input', () => {
		const helpElem = $('#cantidadAsistentesHelp');
		helpElem.text('');
		cantidadAsistentes.removeClass('is-invalid');
	});

	form.on('submit', (event) => {
		event.preventDefault();
		if (!validateForm()) {
		} else {
			createCapacitacion();
/*			rutCliente.val('');
			dia.val('');
			hora.val('');
			lugar.val('');
			duracion.val('');
			cantidadAsistentes.val('');
			rutCliente.removeClass('is-valid is-invalid');
			dia.removeClass('is-valid is-invalid');
			hora.removeClass('is-valid is-invalid');
			lugar.removeClass('is-valid is-invalid');
			duracion.removeClass('is-valid is-invalid');
			cantidadAsistentes.removeClass('is-valid is-invalid');*/
		}
	});

	function createCapacitacion() {
		const rutClienteValue = rutCliente.val();
		const diaValue = dia.val();
		const horaValue = hora.val();
		const lugarValue = lugar.val();
		const duracionValue = duracion.val();
		const cantidadAsistentesValue = cantidadAsistentes.val();

		//req por body
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "./ServletCrearCapacitacion",
			data: JSON.stringify({
				rutCliente: rutClienteValue,
				dia: diaValue,
				hora: horaValue,
				lugar: lugarValue,
				duracion: duracionValue,
				cantidadAsistentes: cantidadAsistentesValue
			}),
			success: function(result) {
				let parsedResult = JSON.parse(result);
				console.log(parsedResult)
				//* retornar un false
				if (parsedResult != false) {
					document.location.href = "ServletListaCapacitaciones";
				}
			}
		});
	}
});

/*$(document).ready(function() {
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
		url: "./ServletCrearCapacitacion",
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
			
				document.location.href = "ServletListaCapacitaciones";
			}
		}
	});
}*/