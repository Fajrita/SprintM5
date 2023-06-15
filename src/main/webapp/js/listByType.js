$(document).ready(function() {
	$("#floatingSelect").change(function() {
		getFormByType();
	});
});

function getFormByType() {
	const type = $("#floatingSelect").val();

	$.ajax({
		type: "POST",
		dataType: "json",
		url: "./ServletListaUsuarios",
		data: $.param({
			type: type,
		}),
		success: function(result) {
			console.log(result);

			let tableContainer = $("#table-container");
			tableContainer.empty();

			if (result.length > 0) {
				const table = $("<table>").addClass("table");
				const thead = $("<thead>").appendTo(table);
				const tbody = $("<tbody>").appendTo(table);

				const headers = Object.keys(result[0]);
				const headerRow = $("<tr>").appendTo(thead);
				headers.forEach(function(header) {
					$("<th>").text(header).appendTo(headerRow);
				});

				result.forEach(function(usuario) {
					let row = $("<tr>").appendTo(tbody);
					Object.values(usuario).forEach(function(value) {
						$("<td>").text(value).appendTo(row);
					});
				});

				tableContainer.append(table);
			} else {
				tableContainer.text("No se encontraron usuarios.");
			}
		}
	});
}
