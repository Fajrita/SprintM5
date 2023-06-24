package cl.awakelab.ejercicio.controller;

import java.util.List;

import cl.awakelab.ejercicio.controller.interfaces.IUsuarioController;
import cl.awakelab.ejercicio.model.entity.Usuario;
import cl.awakelab.ejercicio.services.UsuarioService;

public class UsuarioController implements IUsuarioController {

	UsuarioService usuarioService = new UsuarioService();

	@Override
	public List<Usuario> getUsersByType(String tipoUsuario) {
		try {
			System.out.println(usuarioService);
			return usuarioService.getUsersByType(tipoUsuario);
		} catch (Exception e) {
			System.out.println("Error al obtener usuarios por tipo: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Error al obtener usuarios por tipo: " + e.getMessage(), e);
		}
	}

	@Override
	public void crearUsuario(Usuario usuario) {
		try {
			usuarioService.crearUsuario(usuario);
		} catch (Exception e) {
			System.out.println("Error al crear usuario: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Error al crear usuario: " + e.getMessage(), e);
		}
	}

}
