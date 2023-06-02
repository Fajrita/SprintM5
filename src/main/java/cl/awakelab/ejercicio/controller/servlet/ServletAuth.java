package cl.awakelab.ejercicio.controller.servlet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.awakelab.ejercicio.controller.UserController;
import cl.awakelab.ejercicio.model.entity.User;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/ServletAuth")
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Crear una instancia del controlador
	    UserController userController = new UserController();

	    // Leer los datos del cuerpo de la solicitud en formato JSON
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode jsonNode = mapper.readTree(request.getReader());
	    String username = jsonNode.get("username").asText();
	    String password = jsonNode.get("password").asText();
	    System.out.println(username);
		String result = userController.login(username, password);
		
		if(!result.equals("false")) {
		  // guardamos las credenciales
		  guardarCredenciales(username, password, response);
		  HttpSession session = request.getSession();
		  session.setAttribute("usuario",username);
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
	
	private void guardarCredenciales(String username, String password, HttpServletResponse response) {
	  // aqui voy a crear la cookie
	  
	  Cookie cookie = new Cookie("credenciales", username);
	  cookie.setMaxAge(1000); // la edad la cookie "el tiempo que va durar"
	  response.addCookie(cookie);
	  
	  
	}

}
