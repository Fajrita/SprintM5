// ingreso y validacion de datos para crear capacitaciones
$(document).ready(function () {

	const form = $('#form-capacitacion');
	const rutCliente = $("#rutCliente");
	const dia = $("#dia");

	// restricción de input #dia
	const currentDate = new Date().toISOString().split('T')[0];
	dia.attr('min', currentDate);

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
		} else if (!validateRut(rutClienteValue)) {
			errors['rutCliente'] = 'El formato del rut es inválido';
			setInvalid(rutCliente);
		} else {
			setValid(rutCliente);
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
		if (horaValue.length === 0) {
			errors['hora'] = 'Este campo es obligatorio';
			setInvalid(hora);
		} else {
			const [inputHour, inputMinutes] = horaValue.split(':').map(Number);
			if (inputHour < 8 || inputHour > 22 || (inputHour === 22 && inputMinutes !== 0)) {
				errors['hora'] = 'Ingrese una hora válida entre las 8:00 y las 22:00';
				setInvalid(hora);
			} else {
				setValid(hora);
			}
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

		$.each(errors, function (fieldName, errorMsg) {
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
		const rutClienteValue = rutCliente.val();

		if (rutClienteValue.length === 0) {
			helpElem.text('');
			rutCliente.removeClass('is-invalid is-valid');
		} else if (!validateRut(rutClienteValue)) {
			helpElem.text('El formato del rut es inválido');
			rutCliente.removeClass('is-valid');
			rutCliente.addClass('is-invalid');
		} else {
			helpElem.text('');
			rutCliente.removeClass('is-invalid');
			rutCliente.addClass('is-valid');
		}
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
		}
	});

	function validateRut(rut) {
		// validación básica para rut chileno (formato XX.XXX.XXX-Y)
		const rutRegex = /^[0-9]{2}\.[0-9]{3}\.[0-9]{3}-[0-9kK]{1}$/;
		return rutRegex.test(rut);
	}

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
			success: function (result) {
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
