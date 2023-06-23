$(document).ready(function() {
	const form = $('#contact-form');
	const name = $('#name');
	const email = $('#email');
	const subject = $('#subject');
	const message = $('#message');

	function validate() {
		const specialCharRegex = /^(?=.*[A-Za-z])[A-Za-zñÑáéíóúÁÉÍÓÚ\s]*$/;
		const specialCharExtRegex = /^(?=.*[A-Za-z])[A-Za-zñÑáéíóúÁÉÍÓÚüÜàèìòùÀÈÌÒÙäëïöüÄËÏÖÜâêîôûÂÊÎÔÛçÇñÑÿŸœŒæÆßðÐøØåÅ\s]+$/;
		const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

		const errors = {};

		const nameValue = name.val();
		const emailValue = email.val();
		const subjectValue = subject.val();
		const messageValue = message.val();

		const setValid = (element) => {
			element.removeClass('is-invalid');
			element.addClass('is-valid');
		};

		const setInvalid = (element) => {
			element.removeClass('is-valid');
			element.addClass('is-invalid');
		};

		/**
		 * input name validation
		 */
		if (nameValue.length == 0) {
			errors['name'] = 'Este campo es obligatorio';
			setInvalid(name);
		} else if (!specialCharRegex.test(nameValue)) {
			errors['name'] = 'Este campo no puede tener caracteres especiales';
			setInvalid(name);
		} else if (!specialCharExtRegex.test(nameValue)) {
			errors['name'] = 'Este campo no puede tener caracteres especiales';
			setInvalid(name);
		} else {
			errors['name'] = '';
			setValid(name);
		}

		/**
		 * input email validation
		 */
		if (emailValue.length == 0) {
			errors['email'] = 'Este campo es obligatorio';
			setInvalid(email);
		} else if (!emailRegex.test(emailValue)) {
			errors['email'] = 'El correo no es válido';
			setInvalid(email);
		} else {
			errors['email'] = '';
			setValid(email);
		}

		/**
		 * input subject validation
		 */
		if (subjectValue.length == 0) {
			errors['subject'] = 'Este campo es obligatorio';
			setInvalid(subject);
		} else {
			errors['subject'] = '';
			setValid(subject);
		}

		/**
		 * input message validation
		 */
		if (messageValue.length == 0) {
			errors['message'] = 'Este campo es obligatorio';
			setInvalid(message);
		} else {
			errors['message'] = '';
			setValid(message);
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

	name.on('input', () => {
		const helpElem = $('#nameHelp');
		helpElem.text('');
		name.removeClass('is-invalid');
	});

	email.on('input', () => {
		const helpElem = $('#emailHelp');
		helpElem.text('');
		email.removeClass('is-invalid');
	});

	subject.on('input', () => {
		const helpElem = $('#subjectHelp');
		helpElem.text('');
		subject.removeClass('is-invalid');
	});

	message.on('input', () => {
		const helpElem = $('#messageHelp');
		helpElem.text('');
		message.removeClass('is-invalid');
	});

	form.on('submit', (event) => {
		event.preventDefault();
		if (!validate()) {
		} else {
			createContacto();
			alert('El formulario se envió correctamente');
			name.val('');
			email.val('');
			subject.val('');
			message.val('');
			name.removeClass('is-valid is-invalid');
			email.removeClass('is-valid is-invalid');
			subject.removeClass('is-valid is-invalid');
			message.removeClass('is-valid is-invalid');
		}
	});
		function createContacto() {
		
		const nameValue = name.val();
		const emailValue = email.val();
		const subjectValue = subject.val();
		const messageValue = message.val();
	

		//req por body
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "./ServletContacto",
			data: JSON.stringify({
				name: nameValue,
				email: emailValue,
				subject: subjectValue,
				message: messageValue
			}),
		});
	}
});