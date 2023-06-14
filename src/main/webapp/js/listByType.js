$(document).ready(function() {
    $("#table-usuario").submit(function(event) {
      event.preventDefault();
      getFormByType();
    });
  });

function getFormByType () {
    
    const type = $("#floatingSelect").val();
    console.log(type)

		$.ajax({
            type: "POST",
            dataType: "html",
            url: "./ServletListaUsuarios",
            data: $.param({
              type: type,
            }),
		success: function(result) {
			let parsedResult = JSON.parse(result);
			console.log(parsedResult)
			//* retornar un false
			// if (parsedResult != false) {
			// 	let type = parsedResult['type'];
			// 	document.location.href = "lista-usuarios.jsp?type=" + type;
			// 	return;
			// }
			// if (parsedResult == false) {
			// 	document.location.href = "index.jsp";
			// }
   }
 });
}

