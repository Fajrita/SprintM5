package cl.awakelab.ejercicio.controller;

import java.sql.PreparedStatement;
import java.util.List;

import com.google.gson.Gson;

import cl.awakelab.ejercicio.conexion.DBConnection;
import cl.awakelab.ejercicio.model.entity.Usuario;
import cl.awakelab.ejercicio.services.UsuarioService;

public class UsuarioController {

	UsuarioService usuarioService = new UsuarioService();

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

	public String createUsuario(String nombre, String fecha, int run) {
		Gson gson = new Gson();
		DBConnection conexion = DBConnection.getInstance();

		String sql = "INSERT INTO usuarios (nombre, fecha, run) VALUES (?, ?, ?);";

		try {
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			statement.setString(1, nombre);
			statement.setString(2, fecha);
			statement.setInt(3, run);

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected > 0) {
				Usuario usuario = new Usuario();
				return gson.toJson(usuario);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "false";
	}

}
