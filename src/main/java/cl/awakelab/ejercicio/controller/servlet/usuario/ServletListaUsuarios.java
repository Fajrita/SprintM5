//package cl.awakelab.ejercicio.controller.servlet.usuario;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import cl.awakelab.ejercicio.controller.UsuarioController;
//
///**
// * Servlet implementation class ListaUsuarios
// */
///*
// * @WebServlet("/ListaUsuarios") public class ServletListaUsuarios extends
// * HttpServlet { private static final long serialVersionUID = 1L;
// * 
// * @Override protected void service(HttpServletRequest request,
// * HttpServletResponse response) throws ServletException, IOException {
// * 
// * 
// * response.setContentType("text/html"); String tipoUsuario =
// * request.getParameter("type"); System.out.println(tipoUsuario);
// * UsuarioController usuarioController = new UsuarioController();
// * 
// * System.out.println("Servlet usuario inside");
// * request.setAttribute("usuarios",
// * usuarioController.getUsersByType(tipoUsuario)); RequestDispatcher dispatcher
// * = request.getRequestDispatcher("/lista-usuarios.jsp");
// * dispatcher.forward(request, response); } }
// */
//
//@WebServlet("/ServletListaUsuarios")
//public class ServletListaUsuarios extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	private UsuarioController usuarioController;
//
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		usuarioController = new UsuarioController();
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html");
//		String tipoUsuario = request.getParameter("type");
//
//		System.out.println("Tipo de usuario: " + tipoUsuario);
//
//		request.setAttribute("usuarios", usuarioController.getUsersByType(tipoUsuario));
//		request.getRequestDispatcher("/lista-usuarios.jsp").forward(request, response);
//	}
//}

package cl.awakelab.ejercicio.controller.servlet.usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.awakelab.ejercicio.controller.UsuarioController;
import cl.awakelab.ejercicio.model.entity.Usuario;

@WebServlet("/ServletListaUsuarios")
public class ServletListaUsuarios extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsuarioController usuarioController;
    private ObjectMapper objectMapper;

    @Override
    public void init() {
        usuarioController = new UsuarioController();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String tipoUsuario = request.getParameter("type");
        List<Usuario> usuarios = usuarioController.getUsersByType(tipoUsuario);
      

        String jsonResponse = objectMapper.writeValueAsString(usuarios);

        response.getWriter().write(jsonResponse);
    }
}

