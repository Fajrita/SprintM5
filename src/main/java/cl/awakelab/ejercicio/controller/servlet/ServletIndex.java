package cl.awakelab.ejercicio.controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		
	 System.out.println("estamos en el doGet");
	    for(Cookie cookie: cookies) {
	      if(cookie.getName().equals("credenciales")) {
	        response.sendRedirect("home.jsp");
	        return;	      
	        }
	    }
	  }
	  request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
