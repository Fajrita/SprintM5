package cl.awakelab.ejercicio.controller.servlet.usuario;

import java.io.IOException;
import java.io.BufferedReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.awakelab.ejercicio.controller.interfaces.IUsuarioController;
import cl.awakelab.ejercicio.controller.UsuarioController;
import cl.awakelab.ejercicio.model.entity.Cliente;
import cl.awakelab.ejercicio.model.entity.Administrativo;
import cl.awakelab.ejercicio.model.entity.Profesional;
import cl.awakelab.ejercicio.model.entity.Usuario;

@WebServlet("/ServletCrearUsuario")
public class ServletCrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsuarioController usuarioController;

	public ServletCrearUsuario() {
		super();
		usuarioController = (IUsuarioController) new UsuarioController();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder requestBody = new StringBuilder();
		BufferedReader reader = request.getReader();

		String line;
		while ((line = reader.readLine()) != null) {
			requestBody.append(line);
		}

		String jsonData = requestBody.toString();
		System.out.println(jsonData);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(jsonData);

		String tipoUsuario = jsonNode.get("tipoUsuario").asText();
		System.out.println(tipoUsuario);
		String nombre = jsonNode.get("nombre").asText();
		String fecha = jsonNode.get("fecha").asText();
		int run = jsonNode.get("run").asInt();

		Usuario usuario = null;
		switch (tipoUsuario) {
		case "cliente":
			String telefono = jsonNode.get("telefono").asText();
			String afp = jsonNode.get("afp").asText();
			String sistemaSalud = jsonNode.get("sistemaSalud").asText();
			String direccion = jsonNode.get("direccion").asText();
			String comuna = jsonNode.get("comuna").asText();

			usuario = new Cliente(nombre, fecha, run, telefono, afp, sistemaSalud, direccion, comuna);
			break;

		case "administrativo":
			String area = jsonNode.get("area").asText();
			String experienciaPrevia = jsonNode.get("experienciaPrevia").asText();

			usuario = new Administrativo(nombre, fecha, run, area, experienciaPrevia);
			System.out.println("case administrativo");
			break;

		case "profesional":
			String titulo = jsonNode.get("titulo").asText();
			String fechaIngreso = jsonNode.get("fechaIngreso").asText();

			usuario = new Profesional(nombre, fecha, run, titulo, fechaIngreso);
			break;

		default:
			throw new IllegalArgumentException("Tipo de usuario no válido");
		}
		System.out.println(usuario);
		usuarioController.crearUsuario(usuario);

		response.getWriter().println("Usuario creado exitosamente");
	}
}
