package cl.awakelab.ejercicio.controller.servlet.capacitacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.ejercicio.controller.CapacitacionController;

/**
 * Servlet implementation class ServletListaCapacitaciones
 */
@WebServlet("/ServletListaCapacitaciones")
public class ServletListaCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    CapacitacionController capacitacionController = new CapacitacionController();
	    
	    request.setAttribute("capacitaciones", capacitacionController.findAllCapacitaciones());
	    // reenviar esta informacion a un JSP
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/listaCapacitaciones.jsp");
	    dispatcher.forward(request, response);
	  }
	       
	   
	}
