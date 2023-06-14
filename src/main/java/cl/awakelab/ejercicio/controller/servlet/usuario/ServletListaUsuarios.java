package cl.awakelab.ejercicio.controller.servlet.usuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import cl.awakelab.ejercicio.controller.UsuarioController;

/**
 * Servlet implementation class ListaUsuarios
 */
@WebServlet("/ListaUsuarios")
public class ServletListaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
	    String typeUser = request.getParameter("type");
		
		 UsuarioController usuarioController = new UsuarioController();
	
		//   ObjectMapper mapper = new ObjectMapper();
		//     JsonNode jsonNode = mapper.readTree(request.getReader());
		//     String tipoUsuario = jsonNode.get("type").asText();


		    
		System.out.println("Servlet usuario inside");
		request.setAttribute("usuarios", usuarioController.getUsersByType(typeUser));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-usuarios.jsp");
		dispatcher.forward(request, response);
	}


	}

