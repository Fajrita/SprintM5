//* vamos a implemetar Jquery
$(document).ready(function() {
	$("#form-login").submit(function(event) {
		event.preventDefault();
		authUser();
	});
});

//* la funcion Auth() 
function authUser() {

	let username = $("#user").val();
	let password = $("#password").val();

	//req por body
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "./ServletAuth",
		data: JSON.stringify({
			username: username,
			password: password
		}),
		success: function(result) {
			let parsedResult = JSON.parse(result);
			console.log(parsedResult)
			//* retornar un false
			if (parsedResult != false) {
				let username = parsedResult['username'];
				document.location.href = "home.jsp?username=" + username;
			}
		}
	});
}

/*
  $.ajax({
	type: "POST",
	dataType: "html",
	url: "./ServletAuth",
	data: $.param({
	  username: username,
	  password: password
	}),
	success: function(result) {
	  let parsedResult = JSON.parse(result);
	  console.log(parsedResult)
	  //* retornar un false
	  if(parsedResult != false) {
		let username = parsedResult['username'];
		document.location.href = "home.jsp?username="+username;
	  }
	}
  });
}
*/
// promesas
/*
$.ajax({
	type: "POST",
	url: "./YourServlet",
	data: {
		// Tu data aquí
	},
}).done(function(data) {
	// Esto se ejecuta cuando la solicitud es exitosa.
	console.log("Solicitud exitosa: ", data);
}).fail(function(xhr, status, error) {
	// Esto se ejecuta cuando la solicitud falla.
	console.log("Error: " + error);
	console.log("Status: " + status);
	console.dir(xhr);
});

*/