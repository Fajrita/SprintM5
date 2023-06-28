package cl.awakelab.ejercicio.controller.servlet.usuario;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.awakelab.ejercicio.controller.UsuarioController;
import cl.awakelab.ejercicio.controller.interfaces.IUsuarioController;
import cl.awakelab.ejercicio.model.entity.Administrativo;
import cl.awakelab.ejercicio.model.entity.Cliente;
import cl.awakelab.ejercicio.model.entity.Profesional;
import cl.awakelab.ejercicio.model.entity.Usuario;

/**
 * Servlet implementation class ServletUpdateUsuario
 */
@WebServlet("/ServletUpdateUsuario")
public class ServletUpdateUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsuarioController usuarioController;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUpdateUsuario() {
		super();
		usuarioController = (IUsuarioController) new UsuarioController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		System.out.println(type + " , " + id);
		switch (type) {
		case "cliente": {

			Usuario usuario = usuarioController.findByIdUsuario(id, type);
			System.out.println("el suaurioes: " + usuario);
			System.out.println("el suaurioes: " + usuario.getNombre());
			request.setAttribute("nombre", usuario.getNombre());
			request.setAttribute("fecha", usuario.getFecha());
			request.setAttribute("run", usuario.getRun());
			request.setAttribute("telefono", ((Cliente) usuario).getTelefono());
			request.setAttribute("afp", ((Cliente) usuario).getSistemaSalud());
			request.setAttribute("sistemaSalud", ((Cliente) usuario).getAfp());
			request.setAttribute("direccion", ((Cliente) usuario).getDireccion());
			request.setAttribute("comuna", ((Cliente) usuario).getComuna());

			request.setAttribute("usuario", usuario);

			String url = "update-cliente.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
		case "administrativo": {

			Usuario usuario = usuarioController.findByIdUsuario(id, type);
			System.out.println("el suaurioes: " + usuario);
			System.out.println("el suaurioes: " + usuario.getNombre());
			request.setAttribute("nombre", usuario.getNombre());
			request.setAttribute("fecha", usuario.getFecha());
			request.setAttribute("run", usuario.getRun());
			request.setAttribute("area", ((Administrativo) usuario).getArea());
			request.setAttribute("experienciaPrevia", ((Administrativo) usuario).getExperienciaPrevia());

			request.setAttribute("usuario", usuario);

			String url = "update-administrativo.jsp";
			request.getRequestDispatcher(url).forward(request, response);

		}
		case "profesional": {
			
			Usuario usuario = usuarioController.findByIdUsuario(id, type);
			System.out.println("el suaurioes: " + usuario);
			System.out.println("el suaurioes: " + usuario.getNombre());
			request.setAttribute("nombre", usuario.getNombre());
			request.setAttribute("fecha", usuario.getFecha());
			request.setAttribute("run", usuario.getRun());
			request.setAttribute("titulo", ((Profesional) usuario).getTitulo());
			request.setAttribute("fechaIngreso", ((Profesional) usuario).getFechaIngreso());

			request.setAttribute("usuario", usuario);

			String url = "update-profesional.jsp";
			request.getRequestDispatcher(url).forward(request, response);

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}


		// Redirigir a la página de actualización del usuario
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-usuario.jsp");
//        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
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
		int idUsuario = jsonNode.get("id").asInt();

		Usuario usuario = null;
		
		switch (tipoUsuario) {
		case "cliente":
			String telefono = jsonNode.get("telefono").asText();
			String afp = jsonNode.get("afp").asText();
			String sistemaSalud = jsonNode.get("sistemaSalud").asText();
			String direccion = jsonNode.get("direccion").asText();
			String comuna = jsonNode.get("comuna").asText();
			idUsuario = jsonNode.get("id").asInt();
			usuario = new Cliente(nombre, fecha, run, telefono, afp, sistemaSalud, direccion, comuna, idUsuario);
			break;

		case "administrativo":
			idUsuario = 0;
			String area = jsonNode.get("area").asText();
			String experienciaPrevia = jsonNode.get("experienciaPrevia").asText();
			 idUsuario = jsonNode.get("id").asInt();

			usuario = new Administrativo(nombre, fecha, run, area, experienciaPrevia, idUsuario);
			System.out.println("case administrativo");
			break;

		case "profesional":
			String titulo = jsonNode.get("titulo").asText();
			String fechaIngreso = jsonNode.get("fechaIngreso").asText();
			idUsuario = jsonNode.get("id").asInt();

			usuario = new Profesional(nombre, fecha, run, titulo, fechaIngreso, idUsuario);
			break;

		default:
			throw new IllegalArgumentException("Tipo de usuario no válido");
		}
		System.out.println(usuario);
		usuarioController.updateUsuario(usuario, idUsuario);

		response.getWriter().println("Usuario creado exitosamente");
	}
	

}
