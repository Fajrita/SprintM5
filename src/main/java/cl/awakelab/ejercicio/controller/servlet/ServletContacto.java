package cl.awakelab.ejercicio.controller.servlet;

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
 * Servlet implementation class Contacto
 */
@WebServlet("/ServletContacto")
public class ServletContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Crear una instancia del controlador
	  
	    // Leer los datos del cuerpo de la solicitud en formato JSON
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode jsonNode = mapper.readTree(request.getReader());
	    String name = jsonNode.get("name").asText();
	    String email = jsonNode.get("email").asText();
	    String subject = jsonNode.get("subject").asText();
	    String message = jsonNode.get("message").asText();
	    System.out.println("Nombre: " + name);
	    System.out.println("Correo: " + email);
	    System.out.println("Asunto: " + subject);
	    System.out.println("Mensaje: " + message);
	   
			
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
	}

}
