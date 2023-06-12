package cl.awakelab.ejercicio.controller.servlet.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaUsuarios
 */
<<<<<<<< HEAD:src/main/java/cl/awakelab/ejercicio/controller/servlet/ServletContacto.java
@WebServlet("/ServletContacto")
public class ServletContacto extends HttpServlet {
========
@WebServlet("/ListaUsuarios")
public class ServletListaUsuarios extends HttpServlet {
>>>>>>>> ejercicios:src/main/java/cl/awakelab/ejercicio/controller/servlet/usuario/ServletListaUsuarios.java
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
<<<<<<<< HEAD:src/main/java/cl/awakelab/ejercicio/controller/servlet/ServletContacto.java
    public ServletContacto() {
========
    public ServletListaUsuarios() {
>>>>>>>> ejercicios:src/main/java/cl/awakelab/ejercicio/controller/servlet/usuario/ServletListaUsuarios.java
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
