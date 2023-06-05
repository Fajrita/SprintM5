package cl.awakelab.ejercicio.controller.servlet.capacitacion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.awakelab.ejercicio.controller.CapacitacionController;


/**
 * Servlet implementation class CrearCapacitacion
 */
@WebServlet("/ServletCrearCapacitacion")
public class ServletCrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Crear una instancia del controlador
	   CapacitacionController capacitacionController = new CapacitacionController();

	    // Leer los datos del cuerpo de la solicitud en formato JSON
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode jsonNode = mapper.readTree(request.getReader());
	    String rutCliente = jsonNode.get("rutCliente").asText();
	    String dia = jsonNode.get("dia").asText();
	    String hora = jsonNode.get("hora").asText();
	    String lugar = jsonNode.get("lugar").asText();
	    int duracion = jsonNode.get("duracion").asInt();
	    int cantidadAsistentes = jsonNode.get("cantidadAsistentes").asInt();
		String result = capacitacionController.createCapacitacion(rutCliente, dia, hora, lugar, duracion, cantidadAsistentes);
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}



}
