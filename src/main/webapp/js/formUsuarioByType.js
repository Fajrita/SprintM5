$(document).ready(function() {
	
  
    $("#form-usuario").submit(function(event) {
        event.preventDefault();
    });

    let selectTipoUsuario = document.querySelector('select[name="tipoUsuario"]');

    selectTipoUsuario.addEventListener('change', function() {
        let tipoUsuario = selectTipoUsuario.value;
        let formularioContainer = document.getElementById('formulario-container');

        if (tipoUsuario === "Seleccione tipo de usuario") {
            formularioContainer.innerHTML = '';
            return;
        }

        let url = "form-" + tipoUsuario + ".jsp";

        $.ajax({
            type: 'GET',
            url: url,
            data: { tipoUsuario: tipoUsuario },
            success: function(response) {
                formularioContainer.innerHTML = response;
            }
        });
    });
});
